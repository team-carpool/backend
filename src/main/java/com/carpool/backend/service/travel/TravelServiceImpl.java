package com.carpool.backend.service.travel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carpool.backend.dto.DriverDto;
import com.carpool.backend.dto.PassengerDto;
import com.carpool.backend.dto.TravellerDto;
import com.carpool.backend.model.TravelModel;
import com.carpool.backend.repository.TravelRepository;
import com.carpool.backend.service.user.UserService;
import com.carpool.constants.TravelStatus;

@Service
@Transactional
public class TravelServiceImpl implements TravelService {
	
	private final int BUFFERED_DISTANCE_METER = 2100;
	
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
		
		travelData.setStatus(TravelStatus.ACTIVE);
		
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
		int thresholdDistance = distanceCoveredByDriver + BUFFERED_DISTANCE_METER;
		
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


	@Override
	public List<DriverDto> getNearestDriver(String passengerEmailId) throws Exception {
		
		TravellerDto passengerData = travelRepo.getActiveTravellerById(passengerEmailId);
		String passengerSource = passengerData.getSOURCE_COORD();
		String passengerDestination = passengerData.getDESTINATION_COORD();
		
		// gets the list of all active drivers
		List<TravellerDto> activeDriverList = travelRepo.getActiveDrivers();
		
		// check with geoService which drivers are in range of passenger
		List<DriverDto> nearestDriverList = new ArrayList<>();
		
		for(TravellerDto driver: activeDriverList) {
			String currentDriverLoc = userService.getCurrentLoc(driver.getUSER_ID());
			int distanceCoverByDriverAlone = geoService.getDistance(currentDriverLoc, driver.getDESTINATION_COORD());
			int distanceWithDriver = geoService.getDistance(currentDriverLoc, passengerSource, 
					passengerDestination, driver.getDESTINATION_COORD());
			
			int thresholdDistance = distanceCoverByDriverAlone + BUFFERED_DISTANCE_METER;
			if(distanceWithDriver <= thresholdDistance) {
				DriverDto nearestDriver = new DriverDto(currentDriverLoc, driver.getDESTINATION_COORD(), 
						driver.getUSER_ID(), distanceWithDriver);
				
				nearestDriverList.add(nearestDriver);
			}
		}
		
		return nearestDriverList;
	}

}
