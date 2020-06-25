package com.codejudge.moviebooking.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codejudge.moviebooking.requestmodel.TheatreRequestModel;
import com.codejudge.moviebooking.responsemodel.TheatreResponseModel;
import com.codejudge.moviebooking.service.TheatreService;

@RestController
public class TheatreController {
	
	@Autowired
	TheatreService theatreService;
	
	@PostMapping("/theatres/create")
	public ResponseEntity<TheatreResponseModel> addTheatre(@RequestBody TheatreRequestModel theatreInputDetails)
	{
		return new ResponseEntity<TheatreResponseModel> (theatreService.addTheatre(theatreInputDetails), HttpStatus.OK);
	}

}
