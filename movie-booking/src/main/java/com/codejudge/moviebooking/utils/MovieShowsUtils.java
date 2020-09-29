package com.codejudge.moviebooking.utils;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codejudge.moviebooking.dao.MovieShowsRepository;
import com.codejudge.moviebooking.entity.MovieShowsEntity;
import com.codejudge.moviebooking.requestmodel.MovieShowsRequestModel;

@Service
public class MovieShowsUtils {

	@Autowired
	MovieShowsRepository movieShowsRepository;

	public boolean isTheatreAvailable(MovieShowsRequestModel movieShowsInputDetails, int movieLength) {
		
		 LocalTime theatreUnavailableStartTime = movieShowsInputDetails.getTime().minusMinutes(movieLength);
		 LocalTime theatreUnavailableEndTime = movieShowsInputDetails.getTime().plusMinutes(movieLength);
		 
		 System.out.println("theatreUnavailableStartTime : " + theatreUnavailableStartTime + "\n theatreUnavailableEndTime : " + theatreUnavailableEndTime);
		
		List<MovieShowsEntity> movieShowList =movieShowsRepository.findMovieShow(movieShowsInputDetails.getTheatre_id(), 
				 movieShowsInputDetails.getDate(), theatreUnavailableStartTime, theatreUnavailableEndTime);
		
		System.out.println("MovieShows fromDB : " + movieShowList);
		
		if(!movieShowList.isEmpty())
			return true;
		
		return false;

	}
	
}
