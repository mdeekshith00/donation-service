package com.donation.entity;

import java.time.LocalDate;
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
@Table(name = "blood_component")
public class BloodComponent {

	    private UUID componentId;
	    private UUID donationId;
	    private UUID parentSampleId;
	    private String componentType;      // e.g., "RBC", "Plasma", "Platelet", "Cryo"
	    private int volumeMl;
	    private String bloodGroup;        // e.g., "A+", "B-", etc.
	    private LocalDate collectionDate;
	    private LocalDate expiryDate;
	    private UUID processingBatchId;
	    private String status;            // e.g., "QUARANTINED", "AVAILABLE", etc.
	    private UUID storageLocationId;

	    // Getters and Setters would go here
	


}
