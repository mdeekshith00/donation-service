package com.donation.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.donation.entity.BloodComponent;

public interface BloodComponentRepositary extends JpaRepository<BloodComponent, Integer>{

}
