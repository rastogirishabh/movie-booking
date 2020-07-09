package com.codejudge.moviebooking.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.codejudge.moviebooking.entity.MovieShowsEntity;

public interface MovieShowsRepository extends JpaRepository<MovieShowsEntity, Long>{
	
	@Query(value = "SELECT * FROM Movie_Shows_Master u WHERE u.theatre_id = :theatre_id "
			+ "and u.movie_id = :movie_id and u.date = :date and u.time = :time", 
			  nativeQuery = true)
	public List<MovieShowsEntity> findMovieShow(@Param("theatre_id") String theatre_id, @Param("movie_id") String movie_id,
			@Param("date") LocalDate date, @Param("time") LocalTime time);
	
	 

}
