package com.codejudge.moviebooking.utils;

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

	public boolean isTheatreAvailable(MovieShowsRequestModel movieShowsInputDetails) {
		List<MovieShowsEntity> movieShowList =movieShowsRepository.findMovieShow(movieShowsInputDetails.getTheatre_id(), 
				movieShowsInputDetails.getMovie_id(), movieShowsInputDetails.getDate(), movieShowsInputDetails.getTime());
		
		System.out.println("MovieShows fromDB : " + movieShowList);
		
		if(!movieShowList.isEmpty())
			return true;
		
		return false;

	}
	
}
