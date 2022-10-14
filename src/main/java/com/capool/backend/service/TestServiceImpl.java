package com.capool.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capool.backend.model.TestModel;
import com.capool.backend.repository.TestRepository;

@Service
@Transactional
public class TestServiceImpl implements TestService {
	
	@Autowired
	TestRepository testRepo;
	
	@Override
	public void saveEntity(TestModel tm) {
		testRepo.save(tm);
	}
	
	@Override
	public TestModel getTest(Long id) {
		return testRepo.findById(id).orElseThrow();
	}
	
	@Override
	public List<TestModel> getAll(){
		return testRepo.findAll();
	}
}
