package com.donation.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.donation.entity.DonationEvent;

@Repository
public interface DonationEventRepositary  extends JpaRepository<DonationEvent, Integer>{

}
