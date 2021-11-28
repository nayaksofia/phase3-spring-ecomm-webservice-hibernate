package com.simplilearn.webservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//TODO :: Add proper exception handling for the crude operations

@ControllerAdvice
public class UserExceptionController {
	
	@ExceptionHandler(value=UserNotFoundException.class)
	public ResponseEntity<Object> exception(UserNotFoundException exception){
		
		return new ResponseEntity<Object>("User Not Found !", HttpStatus.NOT_FOUND);
	}
	
    @ExceptionHandler(value=InvalidUserException.class)
	public ResponseEntity<Object> exception(InvalidUserException exception){
		return new ResponseEntity<Object> ("Invalid Request, Compulsory parameters are missings!!! ", HttpStatus.BAD_REQUEST);
	}
}
