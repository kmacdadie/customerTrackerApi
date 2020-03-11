package com.promineotech.customerTrackerApi.repository;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.customerTrackerApi.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	public User findByUserName(String userName);

}
