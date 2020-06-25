package com.codejudge.moviebooking.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.codejudge.moviebooking.dao.TemporaryRepository;
import com.codejudge.moviebooking.exceptions.DateTimeFormateNotValidException;
import com.codejudge.moviebooking.exceptions.MovieDoesNotExistsException;
import com.codejudge.moviebooking.exceptions.TheatreDoesNotExistsException;
import com.codejudge.moviebooking.exceptions.TheatreNotAvailableException;
import com.codejudge.moviebooking.requestmodel.MovieShowsRequestModel;
import com.codejudge.moviebooking.responsemodel.MovieShowsResponseModel;
import com.codejudge.moviebooking.utils.MovieShowsUtils;

public class MovieShowsServiceImpl implements MovieShowsService {
	@Autowired
	MovieShowsUtils movieShowsUtils;
	
	@Autowired
	TemporaryRepository database;
	
	@Override
	public MovieShowsResponseModel createMovieShows(MovieShowsRequestModel movieShowsInputDetails) {
		
		if(!movieShowsUtils.isMovieExist(database.getMovieList()))	{
			throw new MovieDoesNotExistsException("No movie is available with movie id : " + movieShowsInputDetails.getMovie_id());
		}
		
		if(!movieShowsUtils.isTheatreExist(database.getTheatreList())) {
			throw new TheatreDoesNotExistsException("No Theatre is available with Theatre id : " + movieShowsInputDetails.getTheatre_id());
		}
		
		if(!movieShowsUtils.validateDateTimeFormats())
		{
			throw new DateTimeFormateNotValidException("Use yyyy-mm-dd for date and hh24:mm:ss for time");
		}
		
		if(!movieShowsUtils.isTheatreAvailable(movieShowsInputDetails.getDate(),movieShowsInputDetails.getTime()))
		{
			throw new TheatreNotAvailableException("Another movie show is running at theatre ID : " + movieShowsInputDetails.getTheatre_id() + 
					" in the requested slot");
		}
		return null;
	}

}
