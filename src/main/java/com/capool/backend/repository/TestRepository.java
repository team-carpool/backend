package com.capool.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capool.backend.model.TestModel;

@Repository
public interface TestRepository extends JpaRepository<TestModel, Long>{
	
}
