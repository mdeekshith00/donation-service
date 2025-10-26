package com.donation.dto;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import com.common.enums.ResultStatus;
import com.donation.entity.BloodTest;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TestResultDto {
	
	private Integer testOrderId; 
    private int donationId;
    private UUID sampleId;
    private List<String> testsRequested; 
    private String results; 
    private ResultStatus resultStatus; 
    private int reportedBy; 
    private Date reportedAt; 

}
