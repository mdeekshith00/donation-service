package com.donation.vo;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import com.common.enums.ResultStatus;

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
public class TestResultVO {
	
	private UUID sampleId;

    private List<String> testsRequested; // List of test names like "HIV", "HBV", etc.

    private String results; 

    private ResultStatus resultStatus; 
    
    private int reportedBy; // labTechId
    
    private Date reportedAt; 
    

}
