package com.patrick.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patrick.demo.entity.User;
import com.patrick.demo.services.repositories.UserRepository;
import com.patrick.demo.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public Iterable<User> listAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Integer id) {
		return userRepository.findOne(id);
	}

	@Override
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User getUserByApiKey(String apiKey) {
		return userRepository.findByApiKey(apiKey);
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

    @Override
    public void login(String username, String password) {
    }


    @Override
	public User getAuthenticatedUser(String username, String apiKey) throws Exception {

		if(username.isEmpty() || apiKey.isEmpty()) throw new Exception("Invalid username and/or API Key");
		User user = userRepository.findByApiKey(apiKey);
		if(username != user.getUsername()) throw new Exception("Invalid username and/or API Key");
		return user;

	}


}
