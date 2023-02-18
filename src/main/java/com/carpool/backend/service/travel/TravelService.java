package com.carpool.backend.service.travel;

import java.time.LocalDateTime;
import java.util.List;

import com.carpool.backend.dto.DriverDto;
import com.carpool.backend.dto.PassengerDto;

public interface TravelService {
	
	/**
	 * Saves trip data of both driver and passenger into Travel_Table
	 * 
	 * @param emailId
	 * @param isDriving
	 * @param sourceCoord
	 * @param startTime
	 * @param destinationCoord
	 * @param travelDurationMin
	 * @param vehicleNum
	 * @author Ayush Kumar
	 */
	public void saveTrip(String emailId, boolean isDriving, String sourceCoord, LocalDateTime startTime,
			String destinationCoord, long travelDurationMin, String vehicleNum);
	
	
	/**
	 * This method fetch the details of the passengers.
	 * If driver's net distance traveled is under 2Km when S/he picks and drop the passenger.
	 * GeoService gets the distance covered by driver and by driver with passenger(as waypoints)
	 * 
	 * @param driverEmailId
	 * @return List of all nearest passengers.
	 * @throws Exception
	 * @author Ayush Kumar
	 */
	public List<PassengerDto> getNearestPassenger(String driverEmailId) throws Exception;
	
	
	/**
	 * This method will return the list of driver which can matched with this passenger.
	 * This will get the list of all active drivers then check if S/he can pick this passenger
	 * If driver's distance with passenger is within 2 Km.
	 * 
	 * @param  Passenger's EmailId
	 * @return List of all nearest drivers.
	 * @author Ayush Kumar
	 */
	public List<DriverDto> getNearestDriver(String passengerEmailId) throws Exception;
	
}
