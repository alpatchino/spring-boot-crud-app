package com.patrick.demo.controllers;


import com.patrick.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by patri on 19/08/2017.
 */
@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService){ this.userService = userService; }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("users", userService.listAllUsers());
        return "users";
    }

    @RequestMapping("user/{id}")
    public String showUser(@PathVariable Integer id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "user_show";
    }

}
