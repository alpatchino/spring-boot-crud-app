package com.patrick.demo.db.repository;

import org.springframework.data.repository.CrudRepository;

import com.patrick.demo.db.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	
	User findByUsername(String username);
}
