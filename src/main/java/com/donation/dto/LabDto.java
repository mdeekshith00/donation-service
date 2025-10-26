package com.donation.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LabDto {
	    private Integer labId;
	    private String labName;
	    private String location;
	    private String contactPerson;
	    private String contactEmail;
	    private String contactPhone;
	    private String registrationNumber;

}
