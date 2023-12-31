package com.example.leadmanagement.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class InvalidInputException extends RuntimeException{

	private static final long serialVersionUID = 2L;
	
	private String message;
	private String details;
	private String hint;
	private String nextActions;
	private String support;
	
	public InvalidInputException() {}
	
	public InvalidInputException(final String message) {
		this.message = message;
	}
	
	public InvalidInputException(final String message,
			final String details,
			final String hint,
			final String nextAction,
			final String support) {
		
		this.message = message;
		this.details = details;
		this.hint = hint;
		this.nextActions = nextAction;
		this.support = support;
	}
	
}