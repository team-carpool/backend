package com.carpool.backend.service.user;

import java.time.LocalDate;

public interface UserService {
	public void signup(String firstName, String lastName, String email, String password, 
			LocalDate createdDate) throws Exception;
	public void login(String email, String password);

}
