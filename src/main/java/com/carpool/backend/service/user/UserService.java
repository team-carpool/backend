package com.carpool.backend.service.user;

import java.time.LocalDate;

public interface UserService {
	public void signup(String firstName, String lastName, String emailId, String password, 
			LocalDate createdDate) throws Exception;
	
	public String login(String emailId, String password);
	
	public Long getUserIdByEmailId(String emailId);
	
	public String getCurrentLoc(Long userId);

	public String updateLocation(Long userId, String loc);

}
