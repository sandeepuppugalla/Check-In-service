package com.cg.dto;

import java.sql.Date;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightSchedulesDto {
	
	private String flightName;
	
	private String fromCity;

	private String toCity;
	
	private Date departureDate;
	
	private LocalTime departureTime;
		
	private Long flightFare;

}
