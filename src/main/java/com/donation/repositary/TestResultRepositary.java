package com.donation.repositary;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.donation.entity.TestResult;

public interface TestResultRepositary extends JpaRepository<TestResult, Integer>{
	
//	Optional<TestResult> findByTestResultRepositary(Integer )

}
