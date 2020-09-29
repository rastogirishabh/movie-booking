package com.codejudge.moviebooking.utils;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codejudge.moviebooking.dao.MovieRepository;
import com.codejudge.moviebooking.entity.MovieEntity;

@Service
public class MovieUtils {

	@Autowired
	MovieRepository movieRepository;
	
	public boolean isMoviePresent(String movie_id) {
		return movieRepository.existsById(movie_id);
		
		/*
		 * if(!movieList.stream() .filter(movie ->
		 * movie.getMovie_name().equalsIgnoreCase(movie_name))
		 * .collect(Collectors.toList()) .isEmpty()) {
		 * System.out.println("--Movie Already Present--"); return true; }
		 */
	}
	
	public String generateMovieID(String movie_name) {
		String [] movieNameArr = movie_name.split(" ");
		if(movieNameArr.length<1)
			return movie_name;
		else {
			String movie_id="";
			for(int i =movieNameArr.length-1; i>=0; i--) {
				movie_id = movieNameArr[i].concat(movie_id);
			}
			return movie_id;
		}
	}
	
	public Optional<MovieEntity> findMovieById(String movieId) {
		return movieRepository.findById(movieId);
		
	}
	
	public int getMovieRunningTime(String movieId) {
		return movieRepository.getMovieRunningTime(movieId);
	}

}
