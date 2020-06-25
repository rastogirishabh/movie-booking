package com.codejudge.moviebooking.service;

import com.codejudge.moviebooking.requestmodel.TheatreRequestModel;
import com.codejudge.moviebooking.responsemodel.TheatreResponseModel;

public interface TheatreService {

	TheatreResponseModel addTheatre(TheatreRequestModel theatreInputDetails);

}
