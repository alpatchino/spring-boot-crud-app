package com.patrick.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.patrick.demo.db.service.ProductService;

@Controller
public class IndexController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping("/")
	String index(){
		return "index";
	}	
}
