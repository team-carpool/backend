package com.carpool.backend.dto;

/**
 * This DTO is used to return Driver details to passenger.
 */
public class DriverDto {
	
	private String sourceCoord;
	private String destinationCoord;
	private long userId;
	private int totalDistanceWithPassenger;
	
	public DriverDto() {}
	
	public DriverDto(String sourceCoord, String destinationCoord, long userId, int totalDistanceWithPassenger) {
		super();
		this.sourceCoord = sourceCoord;
		this.destinationCoord = destinationCoord;
		this.userId = userId;
		this.totalDistanceWithPassenger = totalDistanceWithPassenger;
	}

	public String getSourceCoord() {
		return sourceCoord;
	}

	public void setSourceCoord(String sourceCoord) {
		this.sourceCoord = sourceCoord;
	}

	public String getDestinationCoord() {
		return destinationCoord;
	}

	public void setDestinationCoord(String destinationCoord) {
		this.destinationCoord = destinationCoord;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getTotalDistanceWithPassenger() {
		return totalDistanceWithPassenger;
	}

	public void setTotalDistanceWithPassenger(int totalDistanceWithPassenger) {
		this.totalDistanceWithPassenger = totalDistanceWithPassenger;
	}
	
	
	
}
