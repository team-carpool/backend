package com.carpool.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.carpool.backend.dto.TravellerDto;
import com.carpool.backend.model.TravelModel;

@Repository
public interface TravelRepository extends JpaRepository<TravelModel, Long>{
	
	@Query("SELECT new com.carpool.backend.dto.TravellerDto(sourceCoord, destinationCoord, isDriving, userId) FROM TravelModel tm "
			+ "WHERE tm.emailId = :emailId and status = 0")
	public TravellerDto getActiveTravellerById(@Param(value = "emailId") String emailId);
	
	
	@Query("SELECT new com.carpool.backend.dto.TravellerDto(sourceCoord, destinationCoord, isDriving, userId) FROM TravelModel tm "
			+ "WHERE tm.isDriving = false and status = 0")
	public List<TravellerDto> getActivePassengers();
	
	
	@Query("SELECT new com.carpool.backend.dto.TravellerDto(sourceCoord, destinationCoord, isDriving, userId) FROM TravelModel tm "
			+ "WHERE tm.isDriving=true and status=0")
	public List<TravellerDto> getActiveDrivers();
	
	@Modifying
	@Query("UPDATE UserModel SET status = 1 WHERE userId = :userId")
	public void setPreviousTravelStatus(@Param(value = "userId") Long userId);
	
}
