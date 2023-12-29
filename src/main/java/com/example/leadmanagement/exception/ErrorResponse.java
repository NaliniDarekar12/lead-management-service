package com.example.leadmanagement.exception;

import lombok.Data;

@Data
public class ErrorResponse {
	
	private Integer status;
	private String errorTitle;
	private String errorMessage;

}
