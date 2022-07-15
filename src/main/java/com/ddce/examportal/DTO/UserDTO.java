package com.ddce.examportal.DTO;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO {
	private String email;
	private String password;
	private String fullName;
	private Instant dateOfBirth;
	private String gender;
}
