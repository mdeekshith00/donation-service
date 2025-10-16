package com.donation.entity;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.common.enums.BloodGroupType;
import com.common.enums.DonationType;
import com.donation.enums.CollectionType;
import com.donation.enums.DonationStatus;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
public class DonationEvent implements Serializable{

	private static final long serialVersionUID = 1L;

		@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "donation_id")
	    private Integer donationId;            // Primary Key
        
	    private Integer donorId;               // Foreign Key to Donor-

	    @Enumerated(EnumType.STRING) 
	    @Column(nullable = true)
	    private BloodGroupType bloodGroup;
	    
	    private Integer bookingId;             // Optional, if booked
	    
	    private Integer siteId;                // campId / fixed center / mobile van
	    
	    private UUID phlebotomistId;       // user/staff id
	    
	    private Instant scheduledAt;        // timestamp
	    
	    private LocalDateTime donationDate;
	    
	    private Instant collectedAt;        // timestamp
	    
	    @Enumerated(EnumType.STRING)
	    @Column(nullable = true)
	    private DonationType donationType; // WHOLE_BLOOD, PLASMA, PLATELETS
	    
	    @Enumerated(EnumType.STRING) 
	    @Column(nullable = true)
	    private CollectionType collectionType; // ENUM: WALK_IN, CAMP, APPOINTMENT, EMERGENCY, DIRECTED
	    
	    private Double volumeCollectedMl;      // in milliliters
	    
	    @Enumerated(EnumType.STRING) 
	    @Column(nullable = true)
	    private DonationStatus status;    
	    
	    private String notes;   
	    
	    private UUID createdBy;             // user id who created
	    
	    private UUID updatedBy;             // user id who updated
	    
	    private Instant createdAt;       
	    
	    private Instant updatedAt;  
	    
	    private String collectedBy; // staff/lab tech ID
	    
	    private boolean alcoholLast24h;      // Alcohol consumption in last 24 hours
	    
	    private boolean tattooLast6Months;   // Tattoo in last 6 months
	    
	    private boolean drugUse;             // Drug use history
	    
	    private int pulse;                   // Pulse rate
	    
	    private double temperature;          // Body temperature in Celsius or Fahrenheit
	    
	    @OneToOne(mappedBy = "donationEvent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    @JsonManagedReference
	    private Lab lab;
	    



}