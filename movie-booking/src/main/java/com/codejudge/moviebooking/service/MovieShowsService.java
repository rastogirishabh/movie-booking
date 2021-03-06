package com.codejudge.moviebooking.service;

import java.time.LocalDate;

import javax.validation.Valid;

import com.codejudge.moviebooking.requestmodel.MovieShowsRequestModel;
import com.codejudge.moviebooking.responsemodel.MovieShowsResponseModel;
import com.codejudge.moviebooking.responsemodel.MovieShowsRunningInTheatre;
import com.codejudge.moviebooking.responsemodel.MoviesRunningInCityResponseModel;

public interface MovieShowsService {

	MovieShowsResponseModel createMovieShows(@Valid MovieShowsRequestModel movieShowsInputDetails);
	
	MoviesRunningInCityResponseModel getMovieShowsByCityAndDate(String movie_id, String city, LocalDate showDate);

	MovieShowsRunningInTheatre getMovieShowsByTheatreId(String theatre_id);

}
