package com.donation.entity;

import java.sql.Date;
import java.util.List;
import java.util.Map;

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
@Table(name = "test_result")
public class TestResult {


	    private int testOrderId; // Primary Key
	    private int donationId;
	    private int sampleId;
	    private List<String> testsRequested; // List of test names like "HIV", "HBV", etc.
	    private Map<String, String> results; // Map of test name -> result value (Positive/Negative/INCONCLUSIVE/etc.)
	    private ResultStatus resultStatus; // Enum for status
	    private int reportedBy; // labTechId
	    private Date reportedAt; // Date and time when reported

	    // Enum to represent the status of the result
	    public enum ResultStatus {
	        PENDING,
	        COMPLETED,
	        REACTIVE
	    }

	    // Getters and Setters can be added here as needed
	


}
