package com.carpool.backend.dto;

public class TravellerDto {
	private String sourceCoord;
	private String destinationCoord;
	private Boolean isDriving;
	private Long userId;
	
	public TravellerDto() {}
	
	public TravellerDto(String sourceCoord, String destinationCoord, Boolean isDriving, Long userId) {
		super();
		this.sourceCoord = sourceCoord;
		this.destinationCoord = destinationCoord;
		this.isDriving = isDriving;
		this.userId = userId;
	}
	
	public String getSOURCE_COORD() {
		return sourceCoord;
	}
	public void setSOURCE_COORD(String sOURCE_COORD) {
		sourceCoord = sOURCE_COORD;
	}

	public String getDESTINATION_COORD() {
		return destinationCoord;
	}
	public void setDESTINATION_COORD(String dESTINATION_COORD) {
		destinationCoord = dESTINATION_COORD;
	}
	public Boolean getIS_DRIVING() {
		return isDriving;
	}
	public void setIS_DRIVING(Boolean iS_DRIVING) {
		isDriving = iS_DRIVING;
	}
	public Long getUSER_ID() {
		return userId;
	}
	public void setUSER_ID(Long uSER_ID) {
		userId = uSER_ID;
	}
}
