package com.donation.entity;

import java.time.LocalDate;
import java.util.UUID;

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
