package com.carpool.backend.service.travel;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
		
		ResponseEntity<Map> res = restTemplate.getForEntity(url.toString(), Map.class);
		System.out.println("**************************"+ res.getBody());
		
		return 0;
	}
}
