package com.carpool.backend.service.user;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carpool.backend.exception.useroperation.UserAlreadyExistException;
import com.carpool.backend.model.UserModel;
import com.carpool.backend.repository.UserRepository;
import com.carpool.constants.UserRole;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepo;

	@Override
	public void signup(String firstName, String lastName, String emailId, String password, LocalDate createdDate) 
			throws Exception {
		
		UserRole role = UserRole.USER;
		
		// TODO[vulnerability]: Encrypt password
		
		UserModel user = new UserModel(firstName, lastName, emailId, password, createdDate);
		user.setRole(role);
		
		if(!userRepo.existsByEmailId(emailId)) {
			userRepo.save(user);
			// TODO: login
		}
		else {
			throw new UserAlreadyExistException(String.format("User Already Exist: %s", emailId));
		}
		
		
	}

	@Override
	public String login(String emailId, String password) {
		UserModel user = userRepo.findByEmailId(emailId);
		if(user==null) {
			return "USER_NOT_EXIST";
		}
		if(user.getPassword().equals(password)) {
			return emailId+";"+password;
		}
		return "PASSWORD_MISSMATCH";
		
	}
	
	@Override
	public Long getUserIdByEmailId(String emailId) {
		return userRepo.findUserIdByEmailId(emailId);
	}
	
	@Override
	public String getCurrentLoc(Long userId) {
		return userRepo.getCurrLocationByUserId(userId);
	}
	
}
