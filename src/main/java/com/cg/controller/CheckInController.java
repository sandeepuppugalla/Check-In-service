package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.CheckInRequestDto;
import com.cg.dto.CheckInResponseDto;
import com.cg.serviceimpl.CheckInServiceImpl;

@RestController
@RequestMapping("/CheckIn")
public class CheckInController {

	@Autowired
	private CheckInServiceImpl service;
	
	@PostMapping("/cerateCheckIn")
	public CheckInResponseDto createCheckIn(@RequestBody CheckInRequestDto request ) {
		return service.createCheckIn(request);
	}
	
	
}
