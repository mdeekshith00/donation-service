package com.donation.service.impl;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.common.constants.ErrorConstants;
import com.common.dto.DonationResponseDto;
import com.common.enums.BloodGroupType;
import com.common.enums.DonationType;
import com.common.enums.StatusType;
import com.common.exception.BloodBankBusinessException;
import com.common.util.BarCodeGeneratorUtil;
import com.donation.dto.DonationEventDto;
import com.donation.entity.BloodComponent;
import com.donation.entity.BloodSample;
import com.donation.entity.DonationEvent;
import com.donation.entity.Lab;
import com.donation.enums.CollectionType;
import com.donation.enums.ComponentType;
import com.donation.enums.DonationStatus;
import com.donation.mapper.helper.BloodComponentSplitter;
import com.donation.repositary.BloodComponentRepositary;
import com.donation.repositary.BloodSampleRepositary;
import com.donation.repositary.DonationEventRepositary;
import com.donation.repositary.LabRepositary;
import com.donation.service.DonationEventService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class DonationEventServiceImpl implements DonationEventService {
	
	private final DonationEventRepositary donationEventRepositary;
	private final LabRepositary labRepo;
	private final BloodSampleRepositary bloodSampleRepositary; 
	private final BloodComponentRepositary bloodComponentRepositary;
	private final static Double sampleblood = 10.00;
	
	
	@Override
	public DonationEventDto addDonationEvent(DonationResponseDto donationEventVo) {
		// TODO Auto-generated method stub
		log.info("donation add into donation event entity ");
		DonationEvent event = new DonationEvent();
		Optional.ofNullable(donationEventVo.getBloodGroup()).map(Enum::name).map(BloodGroupType::valueOf).ifPresent(event::setBloodGroup);
		Optional.ofNullable(donationEventVo.getDonorId()).ifPresent(event::setDonorId);
		Optional.ofNullable(donationEventVo.getEventId()).ifPresent(event::setBookingId);
		Optional.ofNullable(donationEventVo.getVolume()).ifPresent(event::setVolumeCollectedMl);
		Optional.ofNullable(donationEventVo.getDonationType()).map(Enum::name).map(DonationType::valueOf).ifPresent(event::setDonationType);
		Optional.ofNullable(donationEventVo.getTemperature()).ifPresent(event::setTemperature);
		Optional.ofNullable(donationEventVo.getPulse()).ifPresent(event::setPulse);
		Optional.ofNullable(donationEventVo.getAlcoholLast24h()).ifPresent(event::setAlcoholLast24h);
		Optional.ofNullable(donationEventVo.getTattooLast6Months()).ifPresent(event::setTattooLast6Months);
		Optional.ofNullable(donationEventVo.getDrugUse()).ifPresent(event::setDrugUse);
		Optional.ofNullable(donationEventVo.getVolume()).ifPresent(event::setVolumeCollectedMl);

		event.setCollectionType(CollectionType.WALK_IN);
		event.setDonationDate(LocalDateTime.now());
		event.setPhlebotomistId(UUID.randomUUID());
		event.setCreatedAt(Instant.now());
		event.setCollectedAt(Instant.now());
		event.setUpdatedAt(Instant.now());
		event.setStatus(DonationStatus.COLLECTED);
		donationEventRepositary.save(event);
		log.info("donation details saved.....");
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


	@Override
	public DonationEventDto updateDonationEvent( DonationResponseDto donationEventVo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public DonationEventDto getDonationEvent(Integer donationId) {
		// TODO Auto-generated method stub
		 DonationEvent donationEvent =  donationEventRepositary.findById(donationId)
					.orElseThrow(()-> new BloodBankBusinessException(ErrorConstants.DONATION_DETAILS_NOT_FOUND ,HttpStatus.BAD_REQUEST,ErrorConstants.INVALID_DATA));
          
		return DonationEventDto.builder()
				.bookingId(donationEvent.getBookingId())
				.donorId(donationEvent.getDonorId())
				.bloodGroup(donationEvent.getBloodGroup().toString())
				.siteId(donationEvent.getSiteId())
				.phlebotomistId(donationEvent.getPhlebotomistId().toString())
				.scheduledAt(donationEvent.getScheduledAt())
				.collectedAt(donationEvent.getCollectedAt())
				.collectionType(donationEvent.getCollectionType().toString())
				.volumeCollectedMl(donationEvent.getVolumeCollectedMl())
				.status(donationEvent.getStatus().toString())
				.notes(donationEvent.getNotes())
				.createdAt(donationEvent.getCreatedAt())
				.build();
	}

	@Override
	@Transactional
	public String sendBloodToLab(Integer donationId, Integer labId) {
		// TODO Auto-generated method stub
		 DonationEvent donationEvent =  donationEventRepositary.findByDonationIdAndStatus(donationId , DonationStatus.COLLECTED)
					.orElseThrow(()-> new BloodBankBusinessException(ErrorConstants.DONATION_DETAILS_NOT_FOUND ,HttpStatus.BAD_REQUEST,ErrorConstants.INVALID_DATA));
		    
		 log.debug("Fetched DonationEvent: donationId={}, volumeCollected={}ml, bloodGroup={}",
		            donationEvent.getDonationId(), donationEvent.getVolumeCollectedMl(), donationEvent.getBloodGroup());
	  
		 Lab lab = labRepo.findById(labId)
					.orElseThrow(()-> new BloodBankBusinessException(ErrorConstants.LAB_DETAILS_NOT_FOUND ,HttpStatus.BAD_REQUEST,ErrorConstants.INVALID_DATA));
		 log.debug("fetching Lab Details  :{}",lab.getLabId());
		 
		 Double totalVolume = donationEvent.getVolumeCollectedMl();
		    if (totalVolume <= sampleblood) {
			throw  new BloodBankBusinessException(ErrorConstants.BLOOD_QUANTITY_INVALID ,HttpStatus.BAD_REQUEST,ErrorConstants.INVALID_DATA);
			}
		 double remaining  = totalVolume- sampleblood;
		  boolean fullSeparation = totalVolume >= 400;
		 
		 Map<ComponentType, Double> splitMap = BloodComponentSplitter.splitBlood(remaining, fullSeparation);
		 log.info("creating Blood Sample ");
		 BloodSample sample =  BloodSample.builder()
					 .labelBarcode(BarCodeGeneratorUtil.generateBarcode(donationEvent.getBloodGroup().toString(), totalVolume.toString()))
					 .tubeType("EDTA")
					 .collectedAt(LocalDateTime.now())
					 .volumeMl(sampleblood)
					 .storageTemp(4.4)
					 .status(StatusType.COLLECTED)
					 .lab(lab)
					 .build();
		 log.info("creating Blood Components... ");
		 List<BloodComponent> components = splitMap.entrySet().stream()
		            .map(entry -> BloodComponent.builder()
		                    .componentType(entry.getKey())
		                    .volumeMl(entry.getValue())
		                    .bloodGroup(donationEvent.getBloodGroup())
		                    .collectionDate(LocalDate.now())
		                    .processingBatchId(UUID.randomUUID())
		                    .storageLocationId(UUID.randomUUID())
		                    .lab(lab)
		                    .build())
		            .collect(Collectors.toList());
		    
		    bloodSampleRepositary.save(sample);
		    bloodComponentRepositary.saveAll(components);
		    
		    lab.getBloodSamples().add(sample);
		    lab.getBloodComponents().addAll(components);
		    labRepo.save(lab);
		    
//		    donationEvent.setStatus(DonationStatus.SENT_TO_LAB);
		    donationEvent.setUpdatedAt(Instant.now());
		    donationEvent.setUpdatedBy(UUID.randomUUID()); 
		    donationEvent.setLab(lab); 
		    donationEventRepositary.save(donationEvent);
		    
		    log.info("Blood sent to lab successfully: donationId={}, labId={}, totalVolume={}ml, components={}", 
		             donationId, labId, totalVolume, splitMap);

		    return "Blood sented to lab successfully:";
	}



	

}
