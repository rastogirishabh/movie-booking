package com.codejudge.moviebooking.service;

import javax.validation.Valid;

import com.codejudge.moviebooking.requestmodel.MovieShowsRequestModel;
import com.codejudge.moviebooking.responsemodel.MovieShowsResponseModel;

public interface MovieShowsService {

	MovieShowsResponseModel createMovieShows(@Valid MovieShowsRequestModel movieShowsInputDetails);

}
