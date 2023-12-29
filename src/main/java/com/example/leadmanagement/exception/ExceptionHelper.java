package com.example.leadmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice            
public class ExceptionHelper {

	private static final Integer invalidInputStatusCode = 400;

	@ExceptionHandler(value = { InvalidInputException.class })
	public ResponseEntity<Object> handleInvalidInputException(InvalidInputException ex) {
		log.error("Invalid Input Exception: ", ex.getMessage());
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorMessage(ex.getMessage());
		errorResponse.setErrorTitle("InvalidInputException");
		errorResponse.setStatus(invalidInputStatusCode);
		return new ResponseEntity<Object>(errorResponse, HttpStatus.BAD_REQUEST);
	}

}