package com.cg.service;

import com.cg.dto.CheckInRequestDto;
import com.cg.dto.CheckInResponseDto;

public interface ICheckInService {
	CheckInResponseDto createCheckIn(CheckInRequestDto request);

}
