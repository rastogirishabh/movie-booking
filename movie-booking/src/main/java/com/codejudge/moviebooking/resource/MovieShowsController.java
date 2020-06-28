package com.codejudge.moviebooking.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codejudge.moviebooking.requestmodel.MovieShowsRequestModel;
import com.codejudge.moviebooking.responsemodel.MovieShowsResponseModel;
import com.codejudge.moviebooking.service.MovieShowsService;

@RestController
public class MovieShowsController {

	@Autowired
	MovieShowsService movieShowsService;
	
	@PostMapping("/shows/create")
	public ResponseEntity<MovieShowsResponseModel> createMovieShows(@RequestBody 
			@Valid MovieShowsRequestModel movieShowsInputDetails)
	{
		return new ResponseEntity<MovieShowsResponseModel>(movieShowsService.createMovieShows(movieShowsInputDetails), 
				HttpStatus.OK);
	}
}
