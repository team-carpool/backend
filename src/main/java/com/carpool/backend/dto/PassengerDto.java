package com.carpool.backend.dto;

/* This DTO is different from TravellerDto as in TravellerDto distance is present
 * TravellerDto is for db transactions.
 */
public class PassengerDto {
	
	private Long userId;
	private String sourceCoord;
	private String destinationCoord;
	
	/* Distance that need to be covered 
	 * if this passenger selected
	 */
	private int totalDistanceWithPassenger;
	
	public PassengerDto() {}
	
	public PassengerDto(String sourceCoord, String destinationCoord) {
		this.sourceCoord = sourceCoord;
		this.destinationCoord = destinationCoord;
	}
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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
	public int getDistance() {
		return totalDistanceWithPassenger;
	}
	public void setDistance(int distance) {
		this.totalDistanceWithPassenger = distance;
	}

}
