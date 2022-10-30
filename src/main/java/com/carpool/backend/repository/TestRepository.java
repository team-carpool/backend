package com.carpool.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carpool.backend.model.TestModel;

@Repository
public interface TestRepository extends JpaRepository<TestModel, Long>{
	
}
