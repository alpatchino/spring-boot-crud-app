package com.patrick.demo.services;

import com.patrick.demo.entity.User;

public interface UserService {
	
	Iterable<User> listAllUsers();
	
	User getUserById(Integer id);
	
	User getUserByUsername(String username);
	
	User getUserByAccessKey(String accessKey);

	User saveUser(User user);

	void login(String username, String password);

	User getAuthenticatedUser(String username, String apiKey) throws Exception;

}
