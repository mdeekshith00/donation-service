package com.donation.service;

import com.donation.vo.BloodTestVo;

public interface BloodSampleService {
	
	public void sendBloodToTest(Integer sampleId , BloodTestVo bloodTestVo);

}
