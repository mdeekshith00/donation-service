package com.donation.entity;

import java.time.Instant;
import java.util.UUID;

public class DonationEvent {


	    private UUID donationId;            // Primary Key
	    private UUID donorId;               // Foreign Key to Donor-Service
	    private UUID bookingId;             // Optional, if booked
	    private UUID siteId;                // campId / fixed center / mobile van
	    private UUID phlebotomistId;       // user/staff id
	    private Instant scheduledAt;        // timestamp
	    private Instant collectedAt;        // timestamp
	    private CollectionType collectionType; // ENUM: WALK_IN, CAMP, APPOINTMENT, EMERGENCY, DIRECTED
	    private int volumeCollectedMl;      // in milliliters
	    private DonationStatus status;      // Enum or class representing state machine
	    private String notes;               // text notes
	    private UUID createdBy;             // user id who created
	    private UUID updatedBy;             // user id who updated
	    private Instant createdAt;          // timestamp
	    private Instant updatedAt;          // timestamp

	    // Enum for collectionType
	    public enum CollectionType {
	        WALK_IN, CAMP, APPOINTMENT, EMERGENCY, DIRECTED
	    }

	    // Enum for status, example states (you can expand as needed)
	    public enum DonationStatus {
	        PENDING, SCHEDULED, COLLECTED, CANCELLED, COMPLETED
	    }

	    // Getters and Setters can be added below
	


}
