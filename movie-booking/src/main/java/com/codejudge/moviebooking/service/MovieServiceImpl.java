package com.codejudge.moviebooking.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codejudge.moviebooking.dao.TemporaryRepository;
import com.codejudge.moviebooking.exceptions.MovieAlreadyPresentException;
import com.codejudge.moviebooking.requestmodel.MovieRequestModel;
import com.codejudge.moviebooking.responsemodel.MovieResponseModel;
import com.codejudge.moviebooking.utils.MovieUtils;

@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
	MovieUtils movieUtils;
	
	@Autowired
	TemporaryRepository database;
	
	@Autowired
	MovieResponseModel movieCreated;

	@Override
	public MovieResponseModel createMovie(MovieRequestModel movieDetailsReceived) {
		System.out.println("Current movies : " + database.getMovieList());
		
		if(movieUtils.isMoviePresent(movieDetailsReceived.getMovie_name(), database.getMovieList())) {
			throw new MovieAlreadyPresentException("Movie name : " + movieDetailsReceived.getMovie_name());
		}
		
		BeanUtils.copyProperties(movieDetailsReceived, movieCreated);
		movieCreated.setMovie_id(movieUtils.generateMovieID());
		
		database.movieList.add(movieCreated);
		
		System.out.println("New movie added : " + database.getMovieList());
		
		return movieCreated;
	}

}
