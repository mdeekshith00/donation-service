package com.donation.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pre_donation_check")
public class PreDonationCheck {


	    private int checkId;                 // Primary Key
	    private int donationId;              // Foreign Key reference to donation
	    private int systolic;                // Blood pressure systolic
	    private int diastolic;               // Blood pressure diastolic
	    private int pulse;                   // Pulse rate
	    private double temperature;          // Body temperature in Celsius or Fahrenheit
	    private double weightKg;             // Weight in kilograms
	    private double hemoglobin;           // Hemoglobin level
	    
	    private boolean alcoholLast24h;      // Alcohol consumption in last 24 hours
	    private boolean tattooLast6Months;   // Tattoo in last 6 months
	    private boolean drugUse;             // Drug use history
	    
	    private boolean consentGiven;       // Whether consent was given
	    private String result;               // "PASSED" or "FAILED"
	    
	    private int doctorId;                // Doctor's ID
//	  private String remarks;              // Additional remarks
	    private LocalDateTime timestamp;     // Time of the checkup
	    
//		@Enumerated(EnumType.STRING)
//		@Column(nullable = true)
//		private Remarks remarks; // (fit/unfit, reason)
//
//		@Enumerated(EnumType.STRING)
//		@Column(nullable = true)
//		private TestedBy checkedBy; //  (Doctor/Nurse ID)
//
//		@Column(nullable = true)
//		private LocalDate  checkupDate;

	    // Getters and Setters can be added below
	


}
