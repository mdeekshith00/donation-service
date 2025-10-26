package com.donation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	private final DonationEventService donationEventService;
	
	@PostMapping("/donate")
	public ResponseEntity<DonationEventDto>  addDonationEvent(@RequestBody DonationResponseDto donationEventVo) {
		log.info(" sucessfully donar details reached donation service");
		DonationEventDto event =	donationEventService.addDonationEvent(donationEventVo);
		return ResponseEntity.status(HttpStatus.CREATED).body(event);
		
	}
	@GetMapping
	public ResponseEntity<DonationEventDto>  getDonationEvent(@PathVariable Integer donationId) {
		DonationEventDto eventDto = donationEventService.getDonationEvent(donationId);
		return ResponseEntity.status(HttpStatus.CREATED).body(eventDto);
	}
	
	@PostMapping("/sendbloodtolab")
	public ResponseEntity<String> sendBloodToLab(@RequestParam Integer donationId ,@RequestParam  Integer labId) {
	   String message = donationEventService.sendBloodToLab(donationId, labId);
		return ResponseEntity.status(HttpStatus.CREATED).body(message);
	}

}
