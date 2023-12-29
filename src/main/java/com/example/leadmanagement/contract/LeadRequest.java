package com.example.leadmanagement.contract;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class LeadRequest {

	private Long leadId;

	private String firstName;

	private String middleName;

	private String lastName;

	private String mobileNumber;

	private String gender;
	
    @JsonFormat(pattern = "dd-MM-yyyy")
	private Date dob;

	private String email;

}
