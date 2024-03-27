package com.springbootproject.content.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springbootproject.content.exception.UserAlreadyExistsByEmailException;

import lombok.AllArgsConstructor;

@RestControllerAdvice
@AllArgsConstructor
public class ApplicationExceptionHandler {

	private ErrorStructure<String> structure;
	
	private ResponseEntity<ErrorStructure<String>> errorResponse(
		HttpStatus status,String message,String rootCause){
		return new ResponseEntity<ErrorStructure<String>> (structure
				.setStatus(status.value())
				.setMessage(message)
				.setRootCause(rootCause),status);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleUserAlreadyExistsBYEmail(
			UserAlreadyExistsByEmailException ex){
		return errorResponse(HttpStatus.BAD_REQUEST,ex.getMessage(),
				"User already exists with the given email ID");
		
	}
	
}
