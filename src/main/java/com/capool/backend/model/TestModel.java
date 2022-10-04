package com.capool.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  //annotation defines that a class can be mapped to a table; For Hibernate world
@Table(name = "TEST_TABLE") //optional that can override table name, schema name etc; For SQL world
public class TestModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TEST_ID")
	Long id;
	
	@Column(name = "TEST_MESSAGE")
	String msg;
	
	// empty constructor need to be declared for JPA
	protected TestModel() {}
	
	public TestModel(String msg) {
		this.msg = msg;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public String getMsg() {
		return this.msg;
	}
	
	@Override
	public String toString() {
		return String.format("TEST_MODEL[ID: %d, MSG: %s]", this.id, this.msg);
	}
}
