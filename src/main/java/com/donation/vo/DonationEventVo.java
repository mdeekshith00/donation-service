package com.donation.vo;

import java.time.Instant;
import java.util.UUID;

import com.common.enums.DonationStatus;
import com.donation.enums.CollectionType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DonationEventVo {
	
		 private Integer donationId;            // Primary Key
	     
		    private Integer donorId;               // Foreign Key to Donor-Service
		    
		    private Integer bookingId;             // Optional, if booked
		    
		    private Integer siteId;                // campId / fixed center / mobile van
		    
		    private UUID phlebotomistId;       // user/staff id
		    
		    private Instant scheduledAt;        // timestamp
		    
		    private Instant collectedAt;        // timestamp
		    
		    @Enumerated(EnumType.STRING) 
		    private CollectionType collectionType; // ENUM: WALK_IN, CAMP, APPOINTMENT, EMERGENCY, DIRECTED
		    
		    private int volumeCollectedMl;      // in milliliters
		    
		    @Enumerated(EnumType.STRING) 
		    private DonationStatus status;      // Enum or class representing state machine
		    
		    private String notes;               // text notes
		    
		    private UUID createdBy;             // user id who created
		    
		    private UUID updatedBy;             // user id who updated
		    
		    private Instant createdAt;          // timestamp
		    
		    private Instant updatedAt;          // ti

	


}
