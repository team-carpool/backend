package com.carpool.backend.exception.useroperation;

public class UserAlreadyExistException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public UserAlreadyExistException() {
		super();
	}

	public UserAlreadyExistException(String msg) {
		super(msg);
	}
}
