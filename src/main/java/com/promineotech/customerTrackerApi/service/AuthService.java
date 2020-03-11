package com.promineotech.customerTrackerApi.service;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.promineotech.customerTrackerApi.entity.Credentials;
import com.promineotech.customerTrackerApi.entity.User;
import com.promineotech.customerTrackerApi.repository.UserRepository;

@Service
public class AuthService {
	
	@Autowired
	private UserRepository repo;
	
	public User register(Credentials cred) throws AuthenticationException {
		User user = new User();
		user.setUserName(cred.getUserName());
		user.setHash((BCrypt.hashpw(cred.getPassword(), BCrypt.gensalt())));
		try {
			repo.save(user);
			return user;
		} catch (DataIntegrityViolationException e) {
			throw new AuthenticationException("UserName not availble");
		}
	}
	
	public User login(Credentials cred) throws AuthenticationException {
		User foundUser = repo.findByUserName(cred.getUserName());
		if (foundUser != null && BCrypt.checkpw(cred.getPassword(), foundUser.getHash())) {
			return foundUser;
		}
		throw new AuthenticationException("Incorrect userName or password");
	}
	
	public User updateUser(Long id, User user) {
		User foundUser = repo.findOne(id);
		if(foundUser != null) {
			foundUser.setUserName(user.getUserName());
			foundUser.setHash(user.getHash());
			repo.save(foundUser);
		}
		return foundUser;
	}
	
	public void deleteUser(Long id) {
		repo.delete(id);
	}

}
