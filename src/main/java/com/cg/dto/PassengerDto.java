package com.cg.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerDto {

	private Long userId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNo;
	private Long loyaltyPoints;

}
