package com.codejudge.moviebooking.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.codejudge.moviebooking.entity.MovieShowsEntity;
import com.codejudge.moviebooking.entity.Shows;

public interface MovieShowsRepository extends JpaRepository<MovieShowsEntity, Long>{
	
	@Query(value = "SELECT * FROM Movie_Shows_Master u WHERE u.theatre_id = :theatre_id "
			+ " and u.date = :date and u.time between :startTime and :endTime", 
			  nativeQuery = true)
	public List<MovieShowsEntity> findMovieShow(@Param("theatre_id") String theatre_id, @Param("date") LocalDate date, @Param("startTime") 
	LocalTime startTime, @Param("endTime") LocalTime endTime);
	
	@Query(value = "SELECT * FROM Movie_Shows_Master u WHERE u.theatre_id = :theatre_id", nativeQuery = true)
	public List<MovieShowsEntity> findByTheatreId(@Param("theatre_id") String theatre_id);
	
	 

}
