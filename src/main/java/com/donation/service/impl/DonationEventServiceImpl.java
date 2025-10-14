package com.donation.service.impl;

import java.time.Instant;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.common.dto.DonationResponseDto;
import com.common.enums.BloodGroupType;
import com.donation.dto.DonationEventDto;
import com.donation.entity.DonationEvent;
import com.donation.enums.CollectionType;
import com.donation.enums.DonationStatus;
import com.donation.repositary.DonationEventRepositary;
import com.donation.service.DonationEventService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class DonationEventServiceImpl implements DonationEventService {
	
	private final DonationEventRepositary donationEventRepositary;
	
	
	@Override
	public DonationEventDto addDonationEvent(DonationResponseDto donationEventVo) {
		// TODO Auto-generated method stub
		DonationEvent event = new DonationEvent();
		Optional.ofNullable(donationEventVo.getBloodGroup()).map(Enum::name).map(BloodGroupType::valueOf).ifPresent(event::setBloodGroup);
		Optional.ofNullable(donationEventVo.getDonorId()).ifPresent(event::setDonorId);
		Optional.ofNullable(donationEventVo.getEventId()).ifPresent(event::setBookingId);
		Optional.ofNullable(donationEventVo.getVolume()).ifPresent(event::setVolumeCollectedMl);

		event.setCollectionType(CollectionType.WALK_IN);
		event.setCreatedAt(Instant.now());
		event.setCollectedAt(Instant.now());
		event.setUpdatedAt(Instant.now());
		event.setStatus(DonationStatus.COLLECTED);
		donationEventRepositary.save(event);
		
		return DonationEventDto.builder()
				.donationId(null)
				.donorId(event.getDonorId())
				.bookingId(event.getBookingId())
				.volumeCollectedMl(event.getVolumeCollectedMl())
				.bloodGroup(event.getBloodGroup().toString())
				.collectedAt(event.getCollectedAt())
				.collectionType(event.getCollectionType().toString())
				.createdAt(event.getCreatedAt())
				.updatedAt(event.getUpdatedAt())
				.notes(event.getNotes())
				.status(event.getStatus().toString())
				.build();
	}

}
