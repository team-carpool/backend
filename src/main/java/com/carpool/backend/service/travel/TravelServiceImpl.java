package com.carpool.backend.service.travel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carpool.backend.dto.PassengerDto;
import com.carpool.backend.dto.TravellerDto;
import com.carpool.backend.model.TravelModel;
import com.carpool.backend.repository.TravelRepository;
import com.carpool.backend.service.user.UserService;

@Service
@Transactional
public class TravelServiceImpl implements TravelService{
	
	@Autowired
	TravelRepository travelRepo;
	
	@Autowired
	GeocodingService geoService;
	
	@Autowired
	UserService userService;

	@Override
	public void saveTrip(String emailId, boolean isDriving, String sourceCoord, LocalDateTime startTime,
			String destinationCoord, long travelDurationMin, String vehicleNum) {
		
		LocalDateTime arrivalTime = startTime.plusMinutes(travelDurationMin);
		Long userId = userService.getUserIdByEmailId(emailId);
		
		TravelModel travelData = new TravelModel(emailId, userId, isDriving, sourceCoord, startTime,
				destinationCoord, arrivalTime, vehicleNum);
		
		travelRepo.save(travelData);
		
	}

	@Override
	public List<PassengerDto> getNearestPassenger(String driverEmailId) throws Exception {
		TravellerDto activeTraveller = travelRepo.getActiveTravellerById(driverEmailId);
		Boolean isDriving = (Boolean) activeTraveller.getIS_DRIVING();
		
		if(!isDriving) {
			throw new Exception();
		}
		
		String driverSource = (String) activeTraveller.getSOURCE_COORD();
		String driverDestination = (String) activeTraveller.getDESTINATION_COORD();
		int distanceCoveredByDriver = geoService.getDistance(driverSource, driverDestination);
		int bufferedDistanceMeter = 2100;
		int thresholdDistance = distanceCoveredByDriver + bufferedDistanceMeter;
		
		List<PassengerDto> nearestPassenger = new ArrayList<>();
		List<TravellerDto> activePassengerList = travelRepo.getActivePassengers();
		for(TravellerDto passengerData: activePassengerList) {
			String passengerSource = passengerData.getSOURCE_COORD();
			String passengerDestination = passengerData.getDESTINATION_COORD();
			
			int distanceWithPassenger = geoService.getDistance(driverSource, passengerSource, 
					passengerDestination, driverDestination);
			if(distanceWithPassenger<=thresholdDistance) {
				PassengerDto matchedPassenger = new PassengerDto(passengerSource, passengerDestination);
				matchedPassenger.setDistance(distanceWithPassenger);
				Long matchedPassengerUserId = passengerData.getUSER_ID();
				matchedPassenger.setUserId(matchedPassengerUserId);
				nearestPassenger.add(matchedPassenger);
			}
		}
		
		nearestPassenger.sort((a, b)->a.getDistance()-b.getDistance());
		return nearestPassenger;
	}

}
