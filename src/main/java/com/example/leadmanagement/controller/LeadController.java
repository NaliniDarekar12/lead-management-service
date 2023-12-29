package com.example.leadmanagement.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.leadmanagement.contract.LeadErrorResponse;
import com.example.leadmanagement.contract.LeadRequest;
import com.example.leadmanagement.contract.LeadResponse;
import com.example.leadmanagement.contract.LeadSuccessResponse;
import com.example.leadmanagement.domain.Lead;
import com.example.leadmanagement.domain.LeadService;

@RestController
public class LeadController {

	@Autowired
	private LeadService leadService;

	@PostMapping(value = "/leads", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<LeadResponse> createLead(@RequestBody LeadRequest leadRequest) {

		Lead savedLeads = leadService.createLead(leadRequest);
		LeadResponse leadResponse = new LeadResponse();
		if (savedLeads != null) {
			leadResponse.setStatus("success");
			leadResponse.setData("Created Leads Successfully");
		} else {
			leadResponse.setStatus("error");
			leadResponse.setData("Failed to create lead");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(leadResponse);
		}
		
		return ResponseEntity.ok(leadResponse);

	}

	// 2nd Attempt

//	@PostMapping(value = "/leads", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
//	public ResponseEntity<Object> createLead(@RequestBody LeadRequest leadRequest) {
//
//		Lead savedLeads = leadService.createLead(leadRequest);
//		LeadResponse leadResponse = new LeadResponse();
//		if (savedLeads != null) {
//			leadResponse.setStatus("success");
//			leadResponse.setData("Created Leads Successfully");
//			
//		}else {
//		LeadErrorResponse errorResponse = new LeadErrorResponse("E10010", "Lead Already Exists in the database with the lead id ");
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
//		}
//		return ResponseEntity.ok(leadResponse);
//
//	}

	@GetMapping(value = "/leads/by-mobilenumber/{mobileNumber}")
	public ResponseEntity<Object> getLeadByMobileNumber(@PathVariable String mobileNumber) {
		List<Lead> leadListingResponse = leadService.getLeadByMobileNumber(mobileNumber);

		if (leadListingResponse.isEmpty()) {
			LeadErrorResponse errorResponse = new LeadErrorResponse("E10011", "No Lead found with the Mobile Number ");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
		}

		LeadSuccessResponse leadSuccessResponse = new LeadSuccessResponse("success", leadListingResponse);
		return ResponseEntity.ok(leadSuccessResponse);
	}
}
