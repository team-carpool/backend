package com.carpool.backend.service.user;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carpool.backend.model.UserModel;
import com.carpool.backend.repository.UserRepository;
import com.carpool.constants.UserRole;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepo;

	@Override
	public void signup(String firstName, String lastName, String email, String password, LocalDate createdDate) 
			throws Exception{
		
		UserRole role = UserRole.USER;
		
		// TODO: Encrypt password
		
		UserModel user = new UserModel(firstName, lastName, email, password, createdDate);
		user.setRole(role);
		
		if(!userRepo.existsById(email)) {
			userRepo.save(user);
			// TODO: login
		}
		else {
			throw new Exception();
		}
		
		
	}

	@Override
	public void login(String email, String password) {
		// TODO Auto-generated method stub
		
	}
	
	
}
