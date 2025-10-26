package com.donation.mapper.helper;

import org.springframework.stereotype.Component;

import com.donation.dto.BloodSampleDto;
import com.donation.dto.BloodTestResultDto;
import com.donation.dto.LabDto;
import com.donation.dto.TestResultDto;
import com.donation.entity.BloodSample;
import com.donation.entity.BloodTest;
import com.donation.entity.Lab;
import com.donation.entity.TestResult;

@Component
public class MapperHelper {
	
	public BloodTestResultDto entityToBloodTestResultVo(BloodTest bloodTest ) {
		
		  TestResult testResult =  bloodTest.getResultStatus();
		  BloodSample bloodSample = bloodTest.getBloodSample();
		  Lab lab = bloodSample.getLab();
		  
	  return BloodTestResultDto.builder()
			  .bloodTestResultId(bloodTest.getBloodTestResultId())
			  .bloodGroupConfirmed(bloodTest.getBloodGroupConfirmed())
			  .HIVTest(bloodTest.getHIVTest())
			  .HepatitisBTest(bloodTest.getHepatitisBTest())
			  .HepatitisCTest(bloodTest.getHepatitisCTest())
			  .SyphilisTest(bloodTest.getSyphilisTest())
			  .MalariaTest(bloodTest.getMalariaTest())
			  .otherTests(bloodTest.getOtherTests())
			  .testedBy(bloodTest.getTestedBy())
			  .testDateTime(bloodTest.getTestDateTime())
			  .lab(LabDto.builder()
					  .labId(lab.getLabId())
					  .labName(lab.getLabName())
					  .location(lab.getLocation())
					  .contactPerson(lab.getContactPerson())
					  .contactEmail(lab.getContactEmail())
					  .registrationNumber(lab.getRegistrationNumber())
					  .build())
			  .bloodSample(BloodSampleDto.builder()
					  .sampleId(bloodSample.getSampleId())
					  .labelBarcode(bloodSample.getLabelBarcode())
					  .tubeType(bloodSample.getTubeType())
					  .collectedAt(bloodSample.getCollectedAt())
					  .volumeMl(bloodSample.getVolumeMl())
					  .status(bloodSample.getStatus())
					  .build())
			  .testResult(TestResultDto.builder()
					  .testOrderId(testResult.getTestOrderId())
					  .donationId(testResult.getDonationId())
					  .sampleId(testResult.getSampleId())
					  .testsRequested(testResult.getTestsRequested())
					  .results(testResult.getResults())
					  .resultStatus(testResult.getResultStatus())
					  .reportedAt(testResult.getReportedAt())
					  .reportedBy(testResult.getReportedBy())
					  .build())
			  .build();
	}

}
