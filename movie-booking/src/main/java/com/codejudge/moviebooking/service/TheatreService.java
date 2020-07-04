package com.codejudge.moviebooking.service;

import com.codejudge.moviebooking.entity.TheatreEntity;
import com.codejudge.moviebooking.requestmodel.TheatreRequestModel;

public interface TheatreService {

	TheatreEntity addTheatre(TheatreRequestModel theatreInputDetails);

}
