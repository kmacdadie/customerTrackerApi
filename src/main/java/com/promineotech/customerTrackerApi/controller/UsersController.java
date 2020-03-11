package com.promineotech.customerTrackerApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.customerTrackerApi.entity.Credentials;
import com.promineotech.customerTrackerApi.entity.User;
import com.promineotech.customerTrackerApi.service.AuthService;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	private AuthService authService;
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ResponseEntity<Object> register(@RequestBody Credentials cred) {
		try {
			return new ResponseEntity<Object>(authService.register(cred), HttpStatus.CREATED);
		} catch (AuthenticationException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ResponseEntity<Object> login(@RequestBody Credentials cred) {
		try {
			return new ResponseEntity<Object>(authService.login(cred), HttpStatus.OK);
		} catch (AuthenticationException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		}
	}

	
	@RequestMapping(value="/users/{id}", method=RequestMethod.PUT)
	public User updateUser(@PathVariable Long id, @RequestBody User user) {
		return authService.updateUser(id, user);
	}
	
	@RequestMapping(value="/users/{id}", method=RequestMethod.DELETE)
	public void deleteUser(@PathVariable Long id) {
		authService.deleteUser(id);
	}
	

}
