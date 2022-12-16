package com.carpool.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carpool.backend.model.TestModel;
import com.carpool.backend.service.test.TestService;

@RequestMapping("/test")
@RestController
public class TestController {
	
	@Autowired
	TestService testService;
	
	@GetMapping("/hi")
	public String testFunc() {
		return "Hi from testFunc()";
	}
	
	@GetMapping("/getTest")
	public TestModel getTest(@RequestParam(value="id")Long id) {
		return testService.getTest(id);
	}
	
	@GetMapping("/getAll")
	public List<TestModel> getAll(){
		return testService.getAll();
	}
	
	@PostMapping("/saveTest")
	public void saveTest(@RequestBody TestModel tm) {
		testService.saveEntity(tm);
	}
}