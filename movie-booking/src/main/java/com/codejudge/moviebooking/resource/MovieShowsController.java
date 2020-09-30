package com.codejudge.moviebooking.resource;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codejudge.moviebooking.exceptions.DateTimeFormatNotValidException;
import com.codejudge.moviebooking.requestmodel.MovieShowsRequestModel;
import com.codejudge.moviebooking.responsemodel.MovieShowsResponseModel;
import com.codejudge.moviebooking.service.MovieShowsService;
import com.codejudge.moviebooking.utils.MovieShowsUtils;

@RestController
public class MovieShowsController {

	@Autowired
	MovieShowsService movieShowsService;
	
	@Autowired
	MovieShowsUtils movieShowsUtils;
	
	@PostMapping("/shows/create")
	public ResponseEntity<MovieShowsResponseModel> createMovieShows( @Valid @RequestBody MovieShowsRequestModel movieShowsInputDetails) {
		return new ResponseEntity<MovieShowsResponseModel>(movieShowsService.createMovieShows(movieShowsInputDetails), 
				HttpStatus.OK);
	}
	
	@GetMapping("/showsBy")
	public ResponseEntity<MovieShowsResponseModel> getMovieShows(HttpServletRequest request, @RequestParam String city, 
			@RequestParam String movie_id, @RequestParam String date ) {
		
		System.out.println("--getMovieShows--> " + request.getRequestURI()+"?"+request.getQueryString());
		
		System.out.println("Movie ID = " + movie_id);
		System.out.println("city = " + city);
		System.out.println("date = " + date);
		
		LocalDate showDate = movieShowsUtils.validateAndParseDate(date);
		if(showDate==null) {
			throw new DateTimeFormatNotValidException("Invalid Date format!");
		}
		return new ResponseEntity<MovieShowsResponseModel> (movieShowsService.getMovieShowsByCityAndDate(movie_id,city,showDate),
				HttpStatus.OK);
	}
}
