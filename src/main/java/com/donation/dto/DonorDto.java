package com.donation.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DonorDto {
	
//    private Integer donorId; // refering from user
	
	private String bloodGroup;
	
    private String donationEligibilityStatus; // eligible, not eligible, pending approval
	 
	private Boolean isAvailableToDonate;
	
    private LocalDate lastDonationDate;
   
	 private LocalDate nextEligibleDate;
	 
	 private Integer totalDonations;
	    
	 private Integer totalUnitsDonated;
	     
	 private Boolean isEligibleToDonate;
	 
	 private String ineligibilityReason; // e.g., "Low hemoglobin", "Medical condition"
	 
	 private LocalDate temporarilyIneligibleUntil;
	    
	 private Boolean isActive; // If donor is still participating
	 
	 private Boolean isVerified; // If user has passed eligibility verification
	 
	 private String registeredVia; // e.g., "app", "web", "camp"

	 private Double weightInKg;
	 
	 private Double hemoglobinLevel;       // g/dL
	 
	 private Boolean hasChronicDiseases;   // e.g., diabetes, hypertension
	 
	 private String recentMedications;
	 
	 private String medicalConditions; 
	      
	 private LocalDateTime createdAt;
	 
	 private LocalDateTime updatedAt;

}
