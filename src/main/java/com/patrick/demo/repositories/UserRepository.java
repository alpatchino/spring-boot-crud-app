package com.patrick.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.patrick.demo.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	User findByUsername(String username);

	User findByApiKey(String apiKey);
	
}
