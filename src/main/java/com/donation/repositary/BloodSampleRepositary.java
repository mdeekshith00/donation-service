package com.donation.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.donation.entity.BloodSample;

public interface BloodSampleRepositary extends JpaRepository<BloodSample, Integer>{

}
