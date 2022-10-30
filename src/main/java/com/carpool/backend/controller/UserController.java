package com.carpool.backend.controller;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carpool.backend.exception.useroperation.UserAlreadyExistException;
import com.carpool.backend.service.user.UserService;
import com.carpool.constants.UserResponse;

@RequestMapping("/users")
@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/signup")
	public ResponseEntity<UserResponse> signup(@RequestBody Map<String, String> data) {
		String firstName = data.get("firstName");
		String lastName = data.get("lastName");
		String emailId = data.get("emailId");
		String password = data.get("password");
		
		LocalDate createdDate = LocalDate.now();
		
		try {
			userService.signup(firstName, lastName, emailId, password, createdDate);
			return new ResponseEntity<>(UserResponse.USER_CREATED_SUCCESSFULLY, HttpStatus.OK);
		}
		catch(UserAlreadyExistException ex) {
			return new ResponseEntity<>(UserResponse.USER_ALREADY_EXIST, HttpStatus.ALREADY_REPORTED);
		}
		catch(Exception ex) {
			return new ResponseEntity<>(UserResponse.USER_DATA_NOT_PROPER, HttpStatus.EXPECTATION_FAILED);
		}
	}

}
