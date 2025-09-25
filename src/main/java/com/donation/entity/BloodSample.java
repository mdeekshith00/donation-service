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
@Table(name = "blood_sample")
public class BloodSample {


	    private UUID sampleId;            // Unique identifier for the sample
	    private int donationId;          // Donation identifier
	    private String labelBarcode;     // Barcode or QR code label
	    private String tubeType;         // Type of tube (e.g., EDTA, CPDA)
	    private LocalDateTime collectedAt; // Date and time of collection
	    private String collectedBy;     // Person who collected the sample
	    private double storageTemp;      // Storage temperature in Celsius
	    private String status;           // Status (COLLECTED, LOST, SENT_TO_LAB, REJECTED)

	    // Getters and setters can be added here
	


}
