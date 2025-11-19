package com.donation.service;

import com.donation.dto.BloodTestResultDto;
import com.donation.vo.BloodTestVo;

public interface BloodSampleService {
	
	public void sendBloodToTest(Integer sampleId);
	public void updateTestResultAndBloodTest(Integer testOrderId , BloodTestVo bloodTestVo);
	public BloodTestResultDto getBloodTestResult(Integer bloodTestResultId);
	public void verifyBloodSample(Integer sampleId);

}
