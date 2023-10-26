package com.cg.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationResponseDto {

	private Long reservationId;
	private PassengerDto passenger;
	private FlightSchedulesDto flightSchedules;
	private String paymentStatus;
	private String reservationStatus;
	private Long seatNo;

}
