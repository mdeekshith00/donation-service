package com.donation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.common.dto.DonationResponseDto;
import com.donation.dto.DonationEventDto;
import com.donation.service.DonationEventService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/donation-event")
@RequiredArgsConstructor
public class DonationController {
	
	private final String serviceToken = "my-shared-secret";
	private final DonationEventService DonationEventService;
	
	@PostMapping("/donate")
	public ResponseEntity<DonationEventDto>  addDonationEvent(@RequestBody DonationResponseDto donationEventVo) {
		DonationEventDto event =	DonationEventService.addDonationEvent(donationEventVo);
		return ResponseEntity.status(HttpStatus.CREATED).body(event);
		
	}

}
