package com.carpool.backend.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRAVEL_TABLE")
public class TravelModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TRAVEL_ID")
	private Long travelId;
	
	@Column(name = "USER_EMAIL_ID")
	private String emailId;
	
	@Column(name = "USER_ID", nullable = false)
	private Long userId;
	
	@Column(name = "IS_DRIVING", nullable = false)
	private Boolean isDriving;
	
	@Column(name = "SOURCE_COORD", nullable = false)
	private String sourceCoord;
	
	@Column(name = "START_DATE_TIME")
	private LocalDateTime startTime;
	
	@Column(name = "DESTINATION_COORD", nullable = false)
	private String destinationCoord;
	
	@Column(name = "ARRIVAL_DATE_TIME")
	private LocalDateTime arrivalTime;
	
	@Column(name = "VEHICLE_NUMBER", nullable = true)
	private String vehicleNum;
	
	@Column(name = "STATUS", nullable = true)
	private String status;
	
	// passengerTravelId
	// driver_id

	// constructors
	protected TravelModel() {}

	public TravelModel(String emailId, Long userId, Boolean isDriving, String sourceCoord, LocalDateTime startTime,
			String destinationCoord, LocalDateTime arrivalTime, String vehicleNum) {
		super();

		this.emailId = emailId;
		this.userId = userId;
		this.isDriving = isDriving;
		this.sourceCoord = sourceCoord;
		this.startTime = startTime;
		this.destinationCoord = destinationCoord;
		this.arrivalTime = arrivalTime;
		this.vehicleNum = vehicleNum;
	}

	// Getters and Setters
	public Long getTravelId() {
		return travelId;
	}

	protected void setTravelId(Long travelId) {
		this.travelId = travelId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Boolean getIsDriving() {
		return isDriving;
	}

	public void setIsDriving(Boolean isDriving) {
		this.isDriving = isDriving;
	}

	public String getSourceCoord() {
		return sourceCoord;
	}

	public void setSourceCoord(String sourceCoord) {
		this.sourceCoord = sourceCoord;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public String getDestinationCoord() {
		return destinationCoord;
	}

	public void setDestinationCoord(String destinationCoord) {
		this.destinationCoord = destinationCoord;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getVehicleNum() {
		return vehicleNum;
	}

	public void setVehicleNum(String vehicleNum) {
		this.vehicleNum = vehicleNum;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
