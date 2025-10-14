package com.donation.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class BloodSample implements Serializable{


	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sample_id")
		private Integer sampleId;            // Unique identifier for the sample
	    
	    private int donationId;          // Donation identifier
	    
	    private String labelBarcode;     // Barcode or QR code label
	    
	    private String tubeType;         // Type of tube (e.g., EDTA, CPDA)
	    
	    private LocalDateTime collectedAt; // Date and time of collection
	    
	    private String collectedBy;     // Person who collected the sample
	    
	    private double storageTemp;      // Storage temperature in Celsius
	    
	    private String status;           // Status (COLLECTED, LOST, SENT_TO_LAB, REJECTED)

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "donations_id", insertable = false, updatable = false)
	    @JsonBackReference
	    private DonationEvent donationEvent;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "lab_id")
	    @JsonBackReference
	    private Lab lab;

	    @OneToMany(mappedBy = "bloodSample", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    @JsonManagedReference
	    private List<BloodTest> bloodTests = new ArrayList<>();
}
