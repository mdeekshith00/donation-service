package com.donation.service;

import com.common.dto.DonationResponseDto;
import com.donation.dto.DonationEventDto;

public interface DonationEventService {

	public DonationEventDto addDonationEvent(DonationResponseDto donationEventVo);
	public DonationEventDto updateDonationEvent(DonationResponseDto donationEventVo);
	public String sendBloodToLab(Integer donationId ,  Integer labId);
	public DonationEventDto getDonationEvent(Integer donationId);
	
}
