package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/users/")
public class UserController {

	public UserController() {
		super();
	}
	
	@GetMapping(value = "/helloWorld", produces = "application/json")
	@ApiOperation(value = "return hello world string", notes = "print hello world")
	public String getHelloWorld() {
		return "hello world";
	}
	
	

}
