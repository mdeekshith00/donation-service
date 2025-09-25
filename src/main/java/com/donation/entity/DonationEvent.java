package com.donation.entity;

import java.time.Instant;
import java.util.UUID;

import com.donation.enums.CollectionType;
import com.donation.enums.DonationStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "donation_event")
public class DonationEvent {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "donation_id")
	    private Integer donationId;            // Primary Key
        
	    private Integer donorId;               // Foreign Key to Donor-Service
	    
	    private Integer bookingId;             // Optional, if booked
	    
	    private Integer siteId;                // campId / fixed center / mobile van
	    
	    private UUID phlebotomistId;       // user/staff id
	    
	    private Instant scheduledAt;        // timestamp
	    
	    private Instant collectedAt;        // timestamp
	    
	    @Enumerated(EnumType.STRING) 
	    @Column(nullable = true)
	    private CollectionType collectionType; // ENUM: WALK_IN, CAMP, APPOINTMENT, EMERGENCY, DIRECTED
	    
	    private int volumeCollectedMl;      // in milliliters
	    
	    @Enumerated(EnumType.STRING) 
	    @Column(nullable = true)
	    private DonationStatus status;      // Enum or class representing state machine
	    
	    private String notes;               // text notes
	    
	    private UUID createdBy;             // user id who created
	    
	    private UUID updatedBy;             // user id who updated
	    
	    private Instant createdAt;          // timestamp
	    private Instant updatedAt;          // timestamp

}
