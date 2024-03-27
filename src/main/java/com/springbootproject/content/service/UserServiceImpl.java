package com.springbootproject.content.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springbootproject.content.entity.User;
import com.springbootproject.content.exception.UserAlreadyExistsByEmailException;
import com.springbootproject.content.repository.UserRepo;
import com.springbootproject.content.requestdto.UserRequest;
import com.springbootproject.content.responsedto.UserResponse;
import com.springbootproject.content.util.ResponseStructure;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
	
	private UserRepo userRepo;
	private ResponseStructure<UserResponse> structure;
	private PasswordEncoder encoder;
	

	@Override
	public ResponseEntity<ResponseStructure<UserResponse>> registerUser(UserRequest userRequest) {
		if(userRepo.existsByEmail(userRequest.getEmail()))
			throw new UserAlreadyExistsByEmailException("Failed to register user");
		
		User user = userRepo.save(mapToUserEntity(userRequest , new User()));
		
		return ResponseEntity.ok(structure.setStatus(HttpStatus.OK.value())
				.setMessage("User registered successfully")
				.setBody(mapToUserResponse(user))); 
			
	}
	
	private UserResponse mapToUserResponse(User user) {
		return UserResponse.builder()
				.userId(user.getUserId())
				.username(user.getUsername())
				.email(user.getEmail())
				.build();
	}
	


	
	private User mapToUserEntity(UserRequest userRequest, User user) {
		user.setEmail(userRequest.getEmail());
//		user.setPassword(userRequest.getPassword());
		user.setPassword(encoder.encode(userRequest.getPassword()));
		user.setUsername(userRequest.getUsername());
		return user;
	}
	
	
	
	
}
