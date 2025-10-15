package com.donation.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.common.constants.ErrorConstants;
import com.common.exception.BloodBankBusinessException;
import com.common.util.BarCodeGeneratorUtil;
import com.donation.dto.CreateLabDto;
import com.donation.entity.BloodComponent;
import com.donation.entity.BloodSample;
import com.donation.entity.DonationEvent;
import com.donation.entity.Lab;
import com.donation.enums.ComponentStatus;
import com.donation.enums.ComponentType;
import com.donation.enums.DonationStatus;
import com.donation.repositary.BloodComponentRepositary;
import com.donation.repositary.BloodSampleRepositary;
import com.donation.repositary.DonationEventRepositary;
import com.donation.repositary.LabRepositary;
import com.donation.service.LabService;
import com.donation.vo.CreateLabVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class LabServiceImpl implements LabService{
	
	private final DonationEventRepositary donationRepo;
	private final BloodSampleRepositary  bloodSampleRepositary;
	private final BloodComponentRepositary bloodComponentRepositary;
	private final LabRepositary labRepo;
	
	private final static double bloodTest = 10.00;
	
	
	public void splitBlood(Integer donationId , Integer labId) {
		// TODO Auto-generated method stub
		DonationEvent event = donationRepo.findByDonationIdAndStatus(donationId, DonationStatus.COLLECTED)
				.orElseThrow(()-> new BloodBankBusinessException(ErrorConstants.DONATION_DETAILS_NOT_FOUND ,HttpStatus.BAD_REQUEST,ErrorConstants.INVALID_DATA));
		
		Lab lab =  labRepo.findById(labId)
		.orElseThrow(()-> new BloodBankBusinessException(ErrorConstants.LAB_DETAILS_NOT_FOUND ,HttpStatus.BAD_REQUEST,ErrorConstants.INVALID_DATA));
        
		Double bloodQuantity =  event.getVolumeCollectedMl();
		if(bloodQuantity < 50.00 || bloodQuantity == null) {
			throw new BloodBankBusinessException(ErrorConstants.BLOOD_QUANTITY_INVALID ,HttpStatus.BAD_REQUEST,ErrorConstants.INVALID_DATA);
		}
		
		Double boodForTest = (bloodQuantity -bloodTest) - event.getVolumeCollectedMl();
		log.info("Splitting blood for testing in blood sample: {} ml", boodForTest);
		
		BloodSample bloodSample = new BloodSample();
//		BLOOD SAMPLE TO TEST BLOOD 
		bloodSample.setLabelBarcode(BarCodeGeneratorUtil.generateBarcode(String.valueOf(event.getDonationId()), event.getBloodGroup().toString()));
		bloodSample.setTubeType("EDTA");
		bloodSample.setCollectedAt(LocalDateTime.now());
		bloodSample.setVolumeMl(boodForTest);
		bloodSample.setStorageTemp(4.0);
		bloodSample.setStatus("COLLECTED");
		bloodSample.setDonationEvent(event);
		
		bloodSampleRepositary.save(bloodSample);
		
		BloodComponent bloodComponent = new BloodComponent();
		bloodComponent.setVolumeMl(event.getVolumeCollectedMl()-bloodTest);
		bloodComponent.setBloodGroup(null);
		bloodComponent.setCollectionDate(LocalDate.now());
		bloodComponent.setExpiryDate(null);
		bloodComponent.setProcessingBatchId(UUID.fromString(event.getBloodGroup().toString()));
		bloodComponent.setStorageLocationId(UUID.randomUUID());
		bloodComponent.setComponentType(ComponentType.RBC);
		bloodComponent.setStatus(ComponentStatus.AVAILABLE);
		bloodComponent.setParentSampleId(UUID.randomUUID());
		bloodComponent.setDonation(event);
		
		bloodComponentRepositary.save(bloodComponent);
		
	}


	@Override
	public CreateLabDto createLab(CreateLabVO labVO) {
		// TODO Auto-generated method stub
		Lab lab = new Lab();
		Optional.ofNullable(labVO.getLabName()).ifPresent(lab::setLabName);
		Optional.ofNullable(labVO.getLocation()).ifPresent(lab::setLocation);
		Optional.ofNullable(labVO.getContactPerson()).ifPresent(lab::setContactPerson);
		Optional.ofNullable(labVO.getContactEmail()).ifPresent(lab::setContactEmail);
		Optional.ofNullable(labVO.getContactPhone()).ifPresent(lab::setContactPhone);
		Optional.ofNullable(labVO.getRegistrationNumber()).ifPresent(lab::setRegistrationNumber);

		lab.setCreatedAt(LocalDateTime.now());
		lab.setUpdatedAt(LocalDateTime.now());

		labRepo.save(lab);
		return CreateLabDto.builder()
				.labName(lab.getLabName())
				.location(lab.getLocation())
				.contactEmail(lab.getContactEmail())
				.contactPerson(lab.getContactPerson())
				.contactPhone(lab.getContactPhone())
				.registrationNumber(lab.getRegistrationNumber())
				.createdAt(lab.getCreatedAt())
				.updatedAt(lab.getUpdatedAt())
				.build();
	}

}
