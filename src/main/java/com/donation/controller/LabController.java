package com.donation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.donation.dto.CreateLabDto;
import com.donation.service.LabService;
import com.donation.vo.CreateLabVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/lab")
@RequiredArgsConstructor
@RestController
public class LabController {
	
	private final LabService labservice;
	
	@PostMapping("/create")
	public ResponseEntity<CreateLabDto> createLab(@RequestBody CreateLabVO labVO) {
		CreateLabDto labDto =  labservice.createLab(labVO);
		return ResponseEntity.status(HttpStatus.CREATED).body(labDto);
	}

}
