package com.donation.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.donation.dto.CreateLabDto;
import com.donation.entity.Lab;
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

	private final LabRepositary labRepo;
	
	@Override
	public CreateLabDto createLab(CreateLabVO labVO) {
		// TODO Auto-generated method stub
		log.info("new Creating ...");
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
		
		log.info("Sucessfully saved Lab :{} " , lab.getLabId());
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

	@Override
	public void verifyBloodTest(Integer labId) {
		// TODO Auto-generated method stub
//		labRepo.findById(labId).
		
	}







}
