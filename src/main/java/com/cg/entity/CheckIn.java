package com.cg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class CheckIn {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long checkInId;

	private Long baggageId;
	
	private Long reservationId;

	@NotNull
	private Boolean checkInStatus;
	
	@NotNull
	private Boolean isBoarded;
	
	@NotNull
	private Long seatNo;
	
	@NotNull
	private Long noOfBags;

}
