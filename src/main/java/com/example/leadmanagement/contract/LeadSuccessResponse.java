package com.example.leadmanagement.contract;

import java.util.List;

import com.example.leadmanagement.domain.Lead;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeadSuccessResponse {
	
	private String status;
	private List<Lead> data;

}
