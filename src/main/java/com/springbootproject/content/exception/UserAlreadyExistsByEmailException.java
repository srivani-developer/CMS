package com.springbootproject.content.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@SuppressWarnings("serial")
@Getter
@AllArgsConstructor
public class UserAlreadyExistsByEmailException extends RuntimeException {
	
	private String message;

	
	
	

}
