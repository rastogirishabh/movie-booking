package com.codejudge.moviebooking.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.codejudge.moviebooking.entity.TheatreEntity;

public interface TheatreRepository extends JpaRepository<TheatreEntity, String> {
	
	@Query(value = "SELECT theatre_id FROM Theatre_Master WHERE city = :city", nativeQuery = true)
	List<String> findAllTheatreByCity(@Param("city") String city);

}
