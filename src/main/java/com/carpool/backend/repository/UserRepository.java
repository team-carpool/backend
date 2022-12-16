package com.carpool.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carpool.backend.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, String>{

}
