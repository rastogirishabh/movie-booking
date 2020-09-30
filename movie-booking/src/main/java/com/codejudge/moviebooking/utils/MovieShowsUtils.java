package com.codejudge.moviebooking.utils;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codejudge.moviebooking.dao.MovieShowsRepository;
import com.codejudge.moviebooking.entity.MovieShowsEntity;
import com.codejudge.moviebooking.exceptions.MovieDoesNotExistsException;
import com.codejudge.moviebooking.exceptions.TheatreDoesNotExistsException;
import com.codejudge.moviebooking.exceptions.TheatreNotAvailableException;
import com.codejudge.moviebooking.requestmodel.MovieShowsRequestModel;

@Service
public class MovieShowsUtils {

	@Autowired
	MovieShowsRepository movieShowsRepository;
	
	@Autowired
	TheatreUtils theatreUtils;

	@Autowired
	MovieUtils movieUtils;

	public boolean isTheatreAvailable(MovieShowsRequestModel movieShowsInputDetails, int movieLength) {
		System.out.println("--isTheatreAvailable()--");
		
		 LocalTime theatreUnavailableStartTime = movieShowsInputDetails.getTime().minusMinutes(movieLength);
		 LocalTime theatreUnavailableEndTime = movieShowsInputDetails.getTime().plusMinutes(movieLength);
		 
		 System.out.println("theatreUnavailableStartTime : " + theatreUnavailableStartTime + "\n theatreUnavailableEndTime : " + theatreUnavailableEndTime);
		
		List<MovieShowsEntity> movieShowList =movieShowsRepository.findMovieShow(movieShowsInputDetails.getTheatre_id(), 
				 movieShowsInputDetails.getDate(), theatreUnavailableStartTime, theatreUnavailableEndTime);
		
		System.out.println("Movie already running during the requested duration : " + movieShowList);
		
		if(!movieShowList.isEmpty())
			return false;
		
		return true;

	}
	
	public boolean isMovieShowPossible(MovieShowsRequestModel movieShowsInputDetails) {
		
		if(!theatreUtils.isTheatreRegistered(movieShowsInputDetails.getTheatre_id())) {
			throw new TheatreDoesNotExistsException("No Theatre is available with Theatre id : " + movieShowsInputDetails.getTheatre_id());
		}

		if(!movieUtils.isMoviePresent(movieShowsInputDetails.getMovie_id())) { 
			throw new MovieDoesNotExistsException("No movie is available with movie id : " +
					movieShowsInputDetails.getMovie_id()); 
		}
		
		int movieLength = movieUtils.getMovieRunningTime(movieShowsInputDetails.getMovie_id());
		
		if(!isTheatreAvailable(movieShowsInputDetails, movieLength)) {
			throw new TheatreNotAvailableException("Another movie show is running at theatre ID : " + movieShowsInputDetails.getTheatre_id() + 
					" in the requested slot");
		}
		return true;
	}
	
}
