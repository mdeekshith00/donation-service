package com.donation.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.donation.entity.TestResult;

public interface TestResultRepositary extends JpaRepository<TestResult, Integer>{

}
