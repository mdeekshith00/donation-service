package com.donation.vo;

import java.time.LocalDateTime;
import java.util.List;

import com.donation.enums.BloodGroupType;
import com.donation.enums.Results;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BloodTestVo {
	
	    private BloodGroupType bloodGroupConfirmed;
	    private Results HIVTest;
	    private  Results HepatitisBTest;
	    private Results HepatitisCTest;
	    private Results SyphilisTest;
	    private Results MalariaTest;
	    private String otherTests; // free-text for additional tests
	    private String testedBy; // labtech id or name
	    private LocalDateTime testDateTime;
    	private TestResultVO testResult;
    	
    	private String results; 
    	  private List<String> testsRequested;
	

}
