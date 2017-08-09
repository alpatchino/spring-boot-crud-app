package com.patrick.demo.db.service;

import com.patrick.demo.db.entity.User;

public interface UserService extends CRUDService<User>{
	
	User findByUsername(String username);

}
