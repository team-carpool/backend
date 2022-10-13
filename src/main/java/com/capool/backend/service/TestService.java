package com.capool.backend.service;

import java.util.List;

import com.capool.backend.model.TestModel;

public interface TestService {
	public void saveEntity(TestModel tm);
	public TestModel getTest(Long id);
	public List<TestModel> getAll();
}
