package com.patrick.demo.services;

import com.patrick.demo.domain.User;

public interface UserService {
	
	Iterable<User> listAllUsers();
	
	User getUserById(Integer id);
	
	User getUserByUsername(String username);
	
	User getUserByApiKey(String apiKey);

	User saveUser(User user);

}
