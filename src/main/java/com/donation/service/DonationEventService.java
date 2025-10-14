package com.donation.service;

import com.common.dto.DonationResponseDto;
import com.donation.dto.DonationEventDto;

public interface DonationEventService {

	public DonationEventDto addDonationEvent(DonationResponseDto donationEventVo);
}
