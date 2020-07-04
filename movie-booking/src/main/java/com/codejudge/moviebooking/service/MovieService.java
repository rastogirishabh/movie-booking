package com.codejudge.moviebooking.service;

import com.codejudge.moviebooking.entity.MovieEntity;
import com.codejudge.moviebooking.requestmodel.MovieRequestModel;

public interface MovieService {

	MovieEntity createMovie(MovieRequestModel movieRequestModel);

}
