package com.example.leadmanagement.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Integer>  {

	List<Lead> findByMobileNumber(String mobileNumber);

	Optional<Lead> findByLeadId(Long leadId);

}
