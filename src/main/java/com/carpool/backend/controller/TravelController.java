package com.carpool.backend.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carpool.backend.dto.PassengerDto;
import com.carpool.backend.service.travel.TravelService;
import com.carpool.constants.TravelResponse;

@RestController
@RequestMapping("/travel")
public class TravelController {
	
	@Autowired
	TravelService travelService;
	
	@PostMapping("/plan")
	public ResponseEntity<TravelResponse> planTrip(@RequestBody Map<String, String> reqData){
		String emailId = reqData.get("emailId");
		String strIsDriving = reqData.get("isDriving").trim().toLowerCase();
		String sourceCoord = reqData.get("source");
		String strStartTime = reqData.getOrDefault("startTime", null);
		String destinationCoord = reqData.get("destination");
		// distTravelled TODO
		long travelDurationMin = Long.parseLong(reqData.get("travelDuration"));
		String vehicleNum = reqData.get("vehicleNum");
		
		// put travelDurationMin, vehicleNum under isDriving
		boolean isDriving = strIsDriving.equals("true") ? true : false;
		
		DateTimeFormatter dateTimeformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime startTime;
		if(strStartTime!=null)
			startTime = LocalDateTime.parse(strStartTime, dateTimeformatter);
		else
			startTime = LocalDateTime.parse(LocalDateTime.now().format(dateTimeformatter), dateTimeformatter);
		
		travelService.saveTrip(emailId, isDriving, sourceCoord, startTime,
				destinationCoord, travelDurationMin, vehicleNum);
		
		return new ResponseEntity<>(TravelResponse.TRAVEL_PLAN_SAVED, HttpStatus.OK);
		
	}
	
	@GetMapping("/passenger")
	public ResponseEntity<List<PassengerDto>> getPassenger(
			@RequestParam(value="user_email_id")String driverEmailId){
		// TODO[vulnerability]: if just email is passing from req param
		
		try {
			List<PassengerDto> passengers =  travelService.getNearestPassenger(driverEmailId);
			return new ResponseEntity<>(passengers, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
