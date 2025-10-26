package com.donation.dto;

import java.time.LocalDateTime;

import com.common.enums.StatusType;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BloodSampleDto {
	
	private Integer sampleId;     
    private String labelBarcode;     
    private String tubeType;         
    private LocalDateTime collectedAt; 
    private String collectedBy;   
    private Double volumeMl; 
    private double storageTemp;   
    private StatusType status; 

}
