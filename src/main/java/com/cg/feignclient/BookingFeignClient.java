package com.cg.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.dto.PassengerResponseDto;
import com.cg.dto.PassengerUpdateRequestDto;
import com.cg.dto.ReservationResponseDto;

@FeignClient(name = "Booking", url = "http://localhost:8002")
public interface BookingFeignClient {

	@GetMapping(value = "/Passenger/getPassenger/{userId}")
	PassengerResponseDto getPassengerById(@PathVariable Long userId);

	@GetMapping("/Reservation/getReservationById/{reservationId}")
	ReservationResponseDto getReservationById(@PathVariable Long reservationId);

	@PutMapping("/Passenger/updatePassenger")
	String updatePassenger(@RequestBody PassengerUpdateRequestDto request);
}
