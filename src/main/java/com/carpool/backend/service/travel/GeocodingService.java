package com.carpool.backend.service.travel;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.carpool.backend.dto.GeoDistanceDto;

@Service
class GeocodingService {
	private static final String OSRM_URL = "https://router.project-osrm.org";
	private static final String OSRM_ROUTE_SERVICE_URL = "/route/v1/driving/";
	private final RestTemplate restTemplate = new RestTemplate();
	
	public int getDistance(String... waypoints) {
		String overviewParam = "overview=false";
		
		StringBuilder waypointsCoord = new StringBuilder();
		for(String coord : waypoints) {
			// coord must be in format [long,lat]
			waypointsCoord.append(coord).append(";");
		}
		waypointsCoord.deleteCharAt(waypointsCoord.length()-1);
		
		StringBuilder url = new StringBuilder(); 
		url.append(OSRM_URL)
		.append(OSRM_ROUTE_SERVICE_URL)
		.append(waypointsCoord.toString())
		.append("?")
		.append(overviewParam);
		
		GeoDistanceDto res = restTemplate.getForObject(url.toString(), GeoDistanceDto.class);
		System.out.println("**************************"+ res.getDistance());
		return res.getDistance().intValue();
	}
}
