package com.donation.service.impl;


import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.common.constants.ErrorConstants;
import com.common.enums.ResultStatus;
import com.common.enums.StatusType;
import com.common.exception.BloodBankBusinessException;
import com.donation.dto.BloodSampleDto;
import com.donation.dto.BloodTestResultDto;
import com.donation.dto.LabDto;
import com.donation.dto.TestResultDto;
import com.donation.entity.BloodSample;
import com.donation.entity.BloodTest;
import com.donation.entity.Lab;
import com.donation.entity.TestResult;
import com.donation.mapper.helper.MapperHelper;
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
	private final BloodTestRepositary bloodTestRepositary;
	private final TestResultRepositary testResultRepositary;
	private final MapperHelper mapperHelper;
	private final static Double sampleblood = 10.00;
	
	@Override
	public void sendBloodToTest(Integer sampleId) {
		// TODO Auto-generated method stub
		BloodSample sample = bloodSampleRepositary.findBySampleIdAndStatus(sampleId ,StatusType.COLLECTED) 
				.orElseThrow(()-> new BloodBankBusinessException(ErrorConstants.BLOOD_SAMPLE_DETAILS_NOT_FOUND ,HttpStatus.BAD_REQUEST,ErrorConstants.INVALID_DATA));

		boolean check = sample.getVolumeMl().equals(sampleblood);
		
		if(!check) {
			throw new BloodBankBusinessException(ErrorConstants.BLOOD_SAMPLE_DETAILS_NOT_FOUND ,HttpStatus.BAD_REQUEST,ErrorConstants.INVALID_DATA);
		}
        BloodTest bloodTest = new BloodTest();
        bloodTest.setTestedBy(String.valueOf(sample.getLab().getLabId()));
        bloodTest.setLab(sample.getLab());
        bloodTest.setTestDateTime(LocalDateTime.now());
        bloodTest.setBloodSample(sample); 
        
	    TestResult result = new TestResult();
	    result.setDonationId(sample.getLab().getDonationEvents().get(0).getDonationId());
	    result.setResultStatus(ResultStatus.PENDING);
	    result.setReportedBy(sample.getLab().getLabId());
//	    result.setReportedAt(Date.valueOf(LocalDate.now()));
	    result.setSampleId(UUID.randomUUID());
	    testResultRepositary.save(result);
	    
	    bloodTest.setResultStatus(result);
	    bloodTestRepositary.save(bloodTest);

	}

	@Override
	public void updateTestResultAndBloodTest(Integer testOrderId, BloodTestVo bloodTestVo) {
		// TODO Auto-generated method stub
		 BloodTest test =  bloodTestRepositary.findById(testOrderId)
		.orElseThrow(()-> new BloodBankBusinessException(ErrorConstants.BLOOD_SAMPLE_DETAILS_NOT_FOUND ,HttpStatus.BAD_REQUEST,ErrorConstants.INVALID_DATA));
		 
		TestResult result =  test.getResultStatus();
		Optional.ofNullable(bloodTestVo.getResults()).ifPresent(result::setResults);
		Optional.ofNullable(bloodTestVo.getTestsRequested()).ifPresent(result::setTestsRequested);
		result.setResultStatus(ResultStatus.COMPLETED);
		testResultRepositary.save(result);
	
		 Optional.ofNullable(bloodTestVo.getBloodGroupConfirmed()).ifPresent(test::setBloodGroupConfirmed);
		 Optional.ofNullable(bloodTestVo.getHIVTest()).ifPresent(test::setHIVTest);
		 Optional.ofNullable(bloodTestVo.getHepatitisBTest()).ifPresent(test::setHepatitisBTest);
		 Optional.ofNullable(bloodTestVo.getHepatitisCTest()).ifPresent(test::setHepatitisCTest);
		 Optional.ofNullable(bloodTestVo.getSyphilisTest()).ifPresent(test::setSyphilisTest);
		 Optional.ofNullable(bloodTestVo.getMalariaTest()).ifPresent(test::setMalariaTest);
		 Optional.ofNullable(bloodTestVo.getOtherTests()).ifPresent(test::setOtherTests);
		
		 bloodTestRepositary.save(test);
	}

	@Override
	public BloodTestResultDto getBloodTestResult(Integer bloodTestResultId) {
		// TODO Auto-generated method stub
	  BloodTest bloodTest =	bloodTestRepositary.findById(bloodTestResultId)
		.orElseThrow(()-> new BloodBankBusinessException(ErrorConstants.BLOOD_SAMPLE_DETAILS_NOT_FOUND ,HttpStatus.BAD_REQUEST,ErrorConstants.INVALID_DATA));

	  return mapperHelper.entityToBloodTestResultVo(bloodTest);
		
	}

	@Override
	public void verifyBloodSample(Integer sampleId) {
		// TODO Auto-generated method stub
		
	}
	
	

}
