package com.springbootproject.content.service;

import org.springframework.http.ResponseEntity;

import com.springbootproject.content.requestdto.UserRequest;
import com.springbootproject.content.responsedto.UserResponse;
import com.springbootproject.content.util.ResponseStructure;

public interface UserService {
	
	public ResponseEntity<ResponseStructure<UserResponse>> registerUser(UserRequest userRequest);
		
	

}
 