package com.donation.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class CreateLabDto {
	
	private String labName;

    private String location;

    private String contactPerson;

    private String contactEmail;

    private String contactPhone;

    private String registrationNumber;

    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;

}
