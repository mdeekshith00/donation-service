package com.donation.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import com.common.enums.BloodGroupType;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class BloodComponent implements Serializable {

	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sample_id")
		private Integer componentId;
	    private UUID donationId;
	    private UUID parentSampleId;
	    private String componentType;      // e.g., "RBC", "Plasma", "Platelet", "Cryo"
	    private Double volumeMl;
	    private BloodGroupType bloodGroup;        // e.g., "A+", "B-", etc.
	    private LocalDate collectionDate;
	    private LocalDate expiryDate;
	    private UUID processingBatchId;
	    private String status;            // e.g., "QUARANTINED", "AVAILABLE", etc.
	    private UUID storageLocationId;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "lab_id", nullable = false)
	    @JsonBackReference
	    private Lab lab;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "donations_id", insertable = false, updatable = false)
	    @JsonBackReference
	    private DonationEvent donation;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "shipment_id")
	    @JsonBackReference
	    private TransferShipment shipment;



}
