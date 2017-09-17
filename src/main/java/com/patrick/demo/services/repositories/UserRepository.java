package com.patrick.demo.services.repositories;

import org.springframework.data.repository.CrudRepository;

import com.patrick.demo.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	User findByUsername(String username);

	User findByApiKey(String apiKey);
	
}
