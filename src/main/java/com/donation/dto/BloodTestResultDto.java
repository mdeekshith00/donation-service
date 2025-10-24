package com.donation.dto;

import java.time.LocalDateTime;

import com.donation.entity.BloodSample;
import com.donation.entity.Lab;
import com.donation.entity.TestResult;
import com.donation.enums.BloodGroupType;
import com.donation.enums.Results;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BloodTestResultDto {
	
	    private Integer bloodTestResultId;
	    private BloodGroupType bloodGroupConfirmed;
	    private Results HIVTest;
	    private  Results HepatitisBTest;
	    private Results HepatitisCTest;
	    private Results SyphilisTest;
	    private Results MalariaTest;
	    private String otherTests; // free-text for additional tests
	    private String testedBy; // labtech id or name
	    private LocalDateTime testDateTime;
		private LabDto lab;
	    private BloodSampleDto bloodSample;
	    private TestResultDto testResult;

}
