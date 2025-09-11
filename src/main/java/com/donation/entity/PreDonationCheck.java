package com.donation.entity;

import java.time.LocalDateTime;

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
	    private String remarks;              // Additional remarks
	    private LocalDateTime timestamp;     // Time of the checkup

	    // Getters and Setters can be added below
	


}
