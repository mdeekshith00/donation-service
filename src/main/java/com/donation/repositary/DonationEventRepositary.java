package com.donation.repositary;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.donation.entity.DonationEvent;
import com.donation.enums.DonationStatus;

@Repository
public interface DonationEventRepositary  extends JpaRepository<DonationEvent, Integer>{
	
	Optional<DonationEvent> findByDonationIdAndStatus(Integer donationId , DonationStatus status);

}
