package com.example.leadmanagement.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.leadmanagement.contract.LeadRequest;
import com.example.leadmanagement.exception.InvalidInputException;
import com.example.leadmanagement.util.CommonUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LeadService {

	@Autowired
	private LeadRepository leadRepository;

	// create lead
	public Lead createLead(LeadRequest request) {
		Lead lead = new Lead();

		if (CommonUtil.isValidLong(request.getLeadId())) {
			if (this.ValidLeadId(request) == true) {
				throw new InvalidInputException("Lead Already Exists in the database with the lead id");
			} else {
				lead.setLeadId(request.getLeadId());
			}
		} else {
			throw new InvalidInputException("Lead id is required");

		}

		if (CommonUtil.isValidField(request.getFirstName())
				&& CommonUtil.validateLetters(request.getFirstName()) == true) {
			lead.setFirstName(request.getFirstName());
		} else {
			throw new InvalidInputException("First name is required & firstName should strictly contain Alphabets");
		}

		if (CommonUtil.isValidField(request.getMiddleName())
				&& CommonUtil.validateLetters(request.getMiddleName()) == true) {
			lead.setMiddleName(request.getMiddleName());
		} else {
			throw new InvalidInputException("middle name is required & middle name should strictly contain Alphabets");
		}

		if (CommonUtil.isValidField(request.getLastName())
				&& CommonUtil.validateLetters(request.getLastName()) == true) {
			lead.setLastName(request.getLastName());
		} else {
			throw new InvalidInputException("last name is required & last name should strictly contain Alphabets");
		}

		if (request.getGender().contains("Male") || request.getGender().contains("Female")
				|| request.getGender().contains("Others")) {
			lead.setGender(request.getGender());
		} else {
			throw new InvalidInputException("Please use proper gender");
		}

		if (CommonUtil.isValidField(request.getEmail()) && CommonUtil.validateEmailFormat(request.getEmail()) == true) {
			lead.setEmail(request.getEmail());
		} else {
			throw new InvalidInputException("email id required");
		}

		if (CommonUtil.isValidField(request.getMobileNumber())) {
			if (request.getMobileNumber().contains("+") || request.getMobileNumber().length() > 10) {
				throw new InvalidInputException(
						"Mobile number can not have country code. Mobile number should be ten digit number without country code (No spaces).");
			}
		} else {

			lead.setMobileNumber(request.getMobileNumber());
		}

//		if (request.getDob() != null && !request.getDob().before(new Date(0))) {
//			lead.setDob(request.getDob());
//
//		} else {
//			throw new InvalidInputException("Please insert proper dob");
//
//		}

		lead.setDob(request.getDob());

		Lead leadResponse = leadRepository.save(lead);

		return leadResponse;

	}

	// get lead by mobile number
	public List<Lead> getLeadByMobileNumber(String mobileNumber) {
		log.info("get a lead by mobile number" + mobileNumber);
		return leadRepository.findByMobileNumber(mobileNumber);
	}

	public Boolean ValidLeadId(LeadRequest request) {
		boolean leadId;
		Optional<Lead> leadOptional = leadRepository.findByLeadId(request.getLeadId());
		if (leadOptional.isPresent()) {
			leadId = true;
		} else {
			leadId = false;
		}
		return leadId;

	}
}
