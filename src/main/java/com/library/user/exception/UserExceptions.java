package com.library.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptions {
	
	@ExceptionHandler(value= UserNotFoundException.class)
	public ResponseEntity<Object> userNotFoundException(UserNotFoundException ex)
	{
		return new ResponseEntity<>("Borrower not found", HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(value= UserAlreadyExistsException.class)
	public ResponseEntity<Object> userAlreadyExists(UserAlreadyExistsException ex)
	{
		return new ResponseEntity<>("Borrower already exists", HttpStatus.ALREADY_REPORTED);
		
	}

}
