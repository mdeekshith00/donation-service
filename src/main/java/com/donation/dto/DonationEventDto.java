package com.donation.dto;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DonationEventDto {
	
	 private Integer donationId;           
     
	    private Integer donorId;  
	    private String bloodGroup;
	    private Integer bookingId;       
	    private Integer siteId;          
	    private String phlebotomistId;     
	    private Instant scheduledAt;       
	    private Instant collectedAt;      
	    private String collectionType; 
	    private Double volumeCollectedMl;   
	    private String status;       
	    private String notes;            
	    private String createdBy;         
	    private String updatedBy;       
	    private Instant createdAt;       
	    private Instant updatedAt; 

}
