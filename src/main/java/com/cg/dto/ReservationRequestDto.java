package com.cg.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class ReservationRequestDto {
	
	private Long userId;
	private String flightName;
	private String fromCity;
	private String toCity;
	private Date departureDate;
}
