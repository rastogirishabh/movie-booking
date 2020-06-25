package com.codejudge.moviebooking.service;

import com.codejudge.moviebooking.requestmodel.MovieShowsRequestModel;
import com.codejudge.moviebooking.responsemodel.MovieShowsResponseModel;

public interface MovieShowsService {


	MovieShowsResponseModel createMovieShows(MovieShowsRequestModel movieShowsInputDetails);

}
