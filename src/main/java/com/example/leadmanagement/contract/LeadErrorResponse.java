package com.example.leadmanagement.contract;

import java.util.Collections;

import lombok.Data;

@Data
public class LeadErrorResponse {

	private String status;
	private ErrorResponseDetails errorResponse;

	public LeadErrorResponse(String code, String message) {
		this.status = "error";
		this.errorResponse = new ErrorResponseDetails(code, Collections.singletonList(message));
	}

}
