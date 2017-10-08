package com.patrick.demo.web.controllers;


import com.patrick.demo.entity.User;
import com.patrick.demo.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by patri on 19/08/2017.
 */

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService){ this.userService = userService; }

    public static final Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     *
     *      USER MAPPINGS: GetAllUsers, CreateUser, GetUser
     *
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<User> getAllUsers() {
        logger.info("Retrieving all users...");
        return userService.listAllUsers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Integer id) {
        logger.info("Retrieving single user {}...", id);
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public User createUser(@RequestBody User user) {
        logger.info("Creating new user {}...", user);
        return userService.saveUser(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public User updateUser(@PathVariable Integer id, @RequestBody User user){
        logger.info("Updating user {}...", user.getId());
        user.setId(id);
        return userService.saveUser(user);
    }

}
