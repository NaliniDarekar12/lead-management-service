package com.example.leadmanagement.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "lead_table")
public class Lead {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	@Getter
	@Setter
	private Long leadId;

	@Getter
	@Setter
	private String firstName;

	@Getter
	@Setter
	private String middleName;

	@Getter
	@Setter
	private String lastName;

	@Getter
	@Setter
	private String mobileNumber;

	@Getter
	@Setter
	private String gender;

	@Getter
	@Setter
	private Date dob;

	@Getter
	@Setter
	private String email;

}
