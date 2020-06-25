package com.codejudge.moviebooking.service;

import com.codejudge.moviebooking.requestmodel.MovieRequestModel;
import com.codejudge.moviebooking.responsemodel.MovieResponseModel;

public interface MovieService {

	MovieResponseModel createMovie(MovieRequestModel movieRequestModel);

}
