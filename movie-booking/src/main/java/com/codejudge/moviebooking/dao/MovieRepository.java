package com.codejudge.moviebooking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.codejudge.moviebooking.entity.MovieEntity;

public interface MovieRepository extends JpaRepository<MovieEntity, String>{
	
	@Query(value= "SELECT length FROM Movie_Master WHERE movie_id = :movie_id", nativeQuery = true)
	public int getMovieRunningTime( @Param("movie_id") String movie_id);

}
