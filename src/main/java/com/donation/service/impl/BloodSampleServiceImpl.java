package com.donation.service.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.common.constants.ErrorConstants;
import com.common.enums.StatusType;
import com.common.exception.BloodBankBusinessException;
import com.donation.entity.BloodSample;
import com.donation.entity.BloodTest;
import com.donation.entity.TestResult;
import com.donation.repositary.BloodSampleRepositary;
import com.donation.repositary.BloodTestRepositary;
import com.donation.repositary.TestResultRepositary;
import com.donation.service.BloodSampleService;
import com.donation.vo.BloodTestVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BloodSampleServiceImpl implements BloodSampleService {
	
	private final BloodSampleRepositary bloodSampleRepositary;
	private final TestResultRepositary testResultRepositary;
	private final BloodTestRepositary bloodTestRepositary;
	private final static Double sampleblood = 10.00;
	
	@Override
	public void sendBloodToTest(Integer sampleId , BloodTestVo bloodTestVo) {
		// TODO Auto-generated method stub
		BloodSample sample = bloodSampleRepositary.findBySampleIdAndStatus(sampleId ,StatusType.COLLECTED) 
				.orElseThrow(()-> new BloodBankBusinessException(ErrorConstants.BLOOD_SAMPLE_DETAILS_NOT_FOUND ,HttpStatus.BAD_REQUEST,ErrorConstants.INVALID_DATA));

		boolean check = sample.getVolumeMl().equals(sampleblood);
		if(!check) {
			throw new BloodBankBusinessException(ErrorConstants.BLOOD_SAMPLE_DETAILS_NOT_FOUND ,HttpStatus.BAD_REQUEST,ErrorConstants.INVALID_DATA);
		}
		BloodTest bloodTest = new BloodTest();
		
	    TestResult result = new TestResult();
	    Optional.ofNullable(bloodTestVo.getTestResult().getTestsRequested()).ifPresent(result::setTestsRequested);
	    Optional.ofNullable(bloodTestVo.getTestResult().getResults()).ifPresent(result::setResults);
	    Optional.ofNullable(bloodTestVo.getTestResult().getResultStatus()).ifPresent(result::setResultStatus);
	    Optional.ofNullable(bloodTestVo.getTestResult().getReportedBy()).ifPresent(result::setReportedBy);
	    Optional.ofNullable(bloodTestVo.getTestResult().getReportedAt()).ifPresent(result::setReportedAt);
	    result.setSampleId(UUID.randomUUID());
	    result.setBloodTest(bloodTest);
	    
	    testResultRepositary.save(result);
	    

	}
	
	

}
