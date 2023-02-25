package com.carpool.backend.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

class Routes implements Serializable {
	private List<?> legs;
	private String weight_name;
	private String weight;
	private String duration;
	private String distance;
	
	
	public Routes() {
		super();
	}
	public Routes(List<?> legs, String weight_name, String weight, String duration, String distance) {
		super();
		this.legs = legs;
		this.weight_name = weight_name;
		this.weight = weight;
		this.duration = duration;
		this.distance = distance;
	}
	public List<?> getLegs() {
		return legs;
	}
	public void setLegs(List<?> legs) {
		this.legs = legs;
	}
	public String getWeight_name() {
		return weight_name;
	}
	public void setWeight_name(String weight_name) {
		this.weight_name = weight_name;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	
}

public class GeoDistanceDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String code;
	private Routes[] routes;
	
	public GeoDistanceDto() {
		super();
	}

	public GeoDistanceDto(String code, Routes[] routes) {
		super();
		this.code = code;
		this.routes = routes;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Routes[] getRoutes() {
		return routes;
	}
	public void setRoutes(Routes[] routes) {
		this.routes = routes;
	}
	
	public Float getDistance() {
		return Float.parseFloat(this.routes[0].getDistance());
	}
}
