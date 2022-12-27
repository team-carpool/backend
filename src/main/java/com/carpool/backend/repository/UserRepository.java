package com.carpool.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.carpool.backend.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>{
	
	public Boolean existsByEmailId(String emailId);
	
	@Query("SELECT userId FROM UserModel um WHERE emailId = :email_id")
	public Long findUserIdByEmailId(@Param(value = "email_id") String id);

}
