package com.donation.repositary;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.common.enums.StatusType;
import com.donation.entity.BloodSample;

public interface BloodSampleRepositary extends JpaRepository<BloodSample, Integer>{
	
	Optional<BloodSample> findBySampleIdAndStatus(Integer sampleId ,StatusType status);

}
