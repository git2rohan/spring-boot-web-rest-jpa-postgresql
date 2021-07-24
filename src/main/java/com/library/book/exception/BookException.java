package com.library.book.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookException {

	@ExceptionHandler(value= BookNotFoundException.class)
	public ResponseEntity<Object> bookNotFoundException(BookNotFoundException ex)
	{
		return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(value= BookAlreadyExistsException.class)
	public ResponseEntity<Object> bookAlreadyExistsException(BookAlreadyExistsException ex)
	{
		return new ResponseEntity<>("Book already exists", HttpStatus.ALREADY_REPORTED);
		
	}
}
