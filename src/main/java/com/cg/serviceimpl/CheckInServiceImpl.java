package com.cg.serviceimpl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dto.CheckInRequestDto;
import com.cg.dto.CheckInResponseDto;
import com.cg.dto.PassengerDto;
import com.cg.dto.PassengerUpdateRequestDto;
import com.cg.dto.ReservationResponseDto;
import com.cg.entity.CheckIn;
import com.cg.feignclient.BookingFeignClient;
import com.cg.repository.ICheckInRepository;
import com.cg.service.ICheckInService;

@Service
public class CheckInServiceImpl implements ICheckInService {

	@Autowired
	private ICheckInRepository checkInRepository;

	@Autowired
	private BookingFeignClient client;

	@Override
	public CheckInResponseDto createCheckIn(CheckInRequestDto request) {
		CheckIn checkIn = new CheckIn();

		ReservationResponseDto res = client.getReservationById(request.getReservationId());

		Date date = res.getFlightSchedules().getDepartureDate();
		Long id = res.getPassenger().getUserId();
		updateLoyaltyPoints(id);
		if (date.equals(Date.valueOf(LocalDate.now()))) {

			checkIn.setCheckInStatus(Boolean.TRUE);
			checkIn.setIsBoarded(Boolean.TRUE);
			checkIn.setSeatNo(res.getSeatNo());
			checkIn.setNoOfBags(Objects.isNull(request.getNoOfBags()) ? 0 : request.getNoOfBags());
			checkIn.setBaggageId(request.getReservationId());
			checkIn.setReservationId(res.getReservationId());
		}

		CheckIn ch = checkInRepository.save(checkIn);

		return CheckInResponseDto.builder().chechInId(ch.getCheckInId()).checkInStatus(ch.getCheckInStatus())
				.isBoarded(ch.getIsBoarded()).baggageId(res.getReservationId())
				.reservationId(request.getReservationId()).seatNo(ch.getSeatNo()).noOfBags(request.getNoOfBags())
				.build();

	}

	private void updateLoyaltyPoints(Long id) {
		PassengerDto p = client.getPassengerById(id).getPassengers().get(0);
		PassengerUpdateRequestDto request = PassengerUpdateRequestDto.builder().userId(p.getUserId())
				.firstName(p.getFirstName()).lastName(p.getLastName()).email(p.getEmail()).phoneNo(p.getPhoneNo())
				.loyaltyPoints(p.getLoyaltyPoints() + 100).build();

		client.updatePassenger(request);

	}

}
