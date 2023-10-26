package com.cg.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CheckInResponseDto {
	
	private Long chechInId;
	
	private Long reservationId;

	private Boolean checkInStatus;
	
	private Boolean isBoarded;
	
	private Long seatNo;
	
	private Long baggageId;
	
	private Long noOfBags;
}
