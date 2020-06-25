package com.codejudge.moviebooking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codejudge.moviebooking.exceptions.MovieAlreadyPresentException;
import com.codejudge.moviebooking.requestmodel.MovieRequestModel;
import com.codejudge.moviebooking.responsemodel.MovieResponseModel;
import com.codejudge.moviebooking.utils.MovieUtils;

@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
	MovieUtils movieUtils;
	
	List<MovieResponseModel> movieList = new ArrayList<>();

	@Override
	public MovieResponseModel createMovie(MovieRequestModel movieDetailsReceived) {
		
		MovieResponseModel movieCreated = new MovieResponseModel();
		
		if(movieUtils.isMoviePresent(movieDetailsReceived.getMovie_name(), movieList)) {
			throw new MovieAlreadyPresentException("Movie name : " + movieDetailsReceived.getMovie_name());
		}
		
		BeanUtils.copyProperties(movieDetailsReceived, movieCreated);
		movieCreated.setMovie_id(movieUtils.generateMovieID());
		
		movieList.add(movieCreated);
		
		return movieCreated;
	}

}
