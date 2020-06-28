package com.codejudge.moviebooking.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codejudge.moviebooking.requestmodel.MovieRequestModel;
import com.codejudge.moviebooking.responsemodel.MovieResponseModel;
import com.codejudge.moviebooking.service.MovieService;

@RestController
public class MovieController {
	@Autowired
	MovieService movieService;
	
	@PostMapping("/movies/create")
	public ResponseEntity<MovieResponseModel> createMovies(@RequestBody @Valid MovieRequestModel movieRequestModel)
	{
		System.out.println("--Inside CreateMovies of Controller--");
		return new ResponseEntity<MovieResponseModel>(movieService.createMovie(movieRequestModel), HttpStatus.OK);
	}

}
