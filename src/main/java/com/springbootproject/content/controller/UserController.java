package com.springbootproject.content.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootproject.content.requestdto.UserRequest;
import com.springbootproject.content.responsedto.UserResponse;
import com.springbootproject.content.service.UserService;
import com.springbootproject.content.util.ResponseStructure;

@RestController
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/users/register")
	public ResponseEntity<ResponseStructure<UserResponse>> register(@RequestBody UserRequest userRequest) {
		return userService.registerUser(userRequest);
	}

	@GetMapping("/test")
	public String test() {
		return "hello from cms";
	}
}
