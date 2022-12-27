package com.carpool.backend.service.travel;

import java.time.LocalDateTime;
import java.util.List;

import com.carpool.backend.dto.PassengerDto;

public interface TravelService {
	
	public void saveTrip(String emailId, boolean isDriving, String sourceCoord, LocalDateTime startTime,
			String destinationCoord, long travelDurationMin, String vehicleNum);
	
	public List<PassengerDto> getNearestPassenger(String driverEmailId) throws Exception;
	
}
