package com.carpool.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.carpool.backend.dto.TravellerDto;
import com.carpool.backend.model.TravelModel;

@Repository
public interface TravelRepository extends JpaRepository<TravelModel, Long>{
	
	@Query("SELECT new com.carpool.backend.dto.TravellerDto(sourceCoord, destinationCoord, isDriving, userId) FROM TravelModel tm "
			+ "WHERE tm.emailId = :emailId")
	public TravellerDto getActiveTravellerById(@Param(value = "emailId") String emailId);
	
	@Query("SELECT new com.carpool.backend.dto.TravellerDto(sourceCoord, destinationCoord, isDriving, userId) FROM TravelModel tm "
			+ "WHERE tm.isDriving = false")
	public List<TravellerDto> getActivePassengers();
}
