package com.codejudge.moviebooking.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codejudge.moviebooking.dao.MovieRepository;
import com.codejudge.moviebooking.entity.MovieEntity;
import com.codejudge.moviebooking.exceptions.MovieAlreadyPresentException;
import com.codejudge.moviebooking.requestmodel.MovieRequestModel;
import com.codejudge.moviebooking.responsemodel.MovieResponseModel;
import com.codejudge.moviebooking.utils.MovieUtils;

@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
	MovieUtils movieUtils;

	@Autowired
	MovieResponseModel movieCreated;

	@Autowired
	MovieRepository movieRepository;

	@Override
	public MovieEntity createMovie(MovieRequestModel movieDetailsReceived) {
		System.out.println("Movie Details Receieved : " + movieDetailsReceived);

		String movie_id = movieUtils.generateMovieID(movieDetailsReceived.getMovie_name());
		System.out.println("MovieID : " + movie_id);
		
		if(movieUtils.isMoviePresent(movie_id)) { 
			throw new MovieAlreadyPresentException("Movie name : " +
					movieDetailsReceived.getMovie_name()); }

		MovieEntity movieEntity = new MovieEntity();
		movieEntity.setMovie_id(movie_id);
		
		BeanUtils.copyProperties(movieDetailsReceived, movieEntity);
		System.out.println("MovieEntity : " + movieEntity);
		
		movieEntity = movieRepository.save(movieEntity);

		return movieEntity;
	}

}
