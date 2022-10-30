package com.carpool.backend.service.test;

import java.util.List;

import com.carpool.backend.model.TestModel;

public interface TestService {
	public void saveEntity(TestModel tm);
	public TestModel getTest(Long id);
	public List<TestModel> getAll();
}
