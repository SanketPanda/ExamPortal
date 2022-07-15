package com.ddce.examportal.service;

import java.util.Optional;

import com.ddce.examportal.DTO.UserDTO;
import com.ddce.examportal.entity.User;

public interface UserService {
	User createUser(UserDTO userDTO);

	User updateUserById(Long id);

	Optional<User> findUserById(Long id);

	void deleteUserById(Long id);
}
