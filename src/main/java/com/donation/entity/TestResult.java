package com.donation.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.common.enums.ResultStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name = "test_result")
public class TestResult implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_order_id")
		private Integer testOrderId; // Primary Key
	
	    @Column(name = "donation_id")
	    private int donationId;
	    
	    @Column(name = "sample_id")
	    private UUID sampleId;
	    
	    @Column(name = "tests_Requested")
	    private List<String> testsRequested; // List of test names like "HIV", "HBV", etc.
	    
	    @Column(name = "results", length = 2000)
	    private String results; // Map of test name -> result value (Positive/Negative/INCONCLUSIVE/etc.)
	    
	    @Enumerated(EnumType.STRING)
	    @Column(nullable = false)
	    private ResultStatus resultStatus; // Enum for status
	    
	    private int reportedBy; // labTechId
	    
	    private Date reportedAt; // Date and time when reported
	    
	    @OneToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "blood_test_id")
	    @JsonBackReference
	    private BloodTest bloodTest;



	    // Getters and Setters can be added here as needed
	


}
