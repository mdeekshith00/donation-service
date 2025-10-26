package com.donation.service;

import com.donation.dto.CreateLabDto;
import com.donation.vo.CreateLabVO;

public interface LabService {
	
	public CreateLabDto createLab(CreateLabVO labVO);
	public void verifyBloodTest(Integer labId);

}
