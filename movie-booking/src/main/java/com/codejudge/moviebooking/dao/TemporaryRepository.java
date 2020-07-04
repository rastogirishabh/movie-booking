package com.codejudge.moviebooking.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.codejudge.moviebooking.responsemodel.MovieResponseModel;
import com.codejudge.moviebooking.responsemodel.MovieShowsResponseModel;
import com.codejudge.moviebooking.responsemodel.TheatreResponseModel;



@Component
public class TemporaryRepository {
	
	public List<MovieResponseModel> movieList = new ArrayList<>();
	public List<TheatreResponseModel> theatreList = new ArrayList<>();
	public List<MovieShowsResponseModel> movieShowsList = new ArrayList<>();
	
	
	public List<MovieResponseModel> getMovieList() {
		return movieList;
	}
	
	public List<TheatreResponseModel> getTheatreList() {
		return theatreList;
	}

	public List<MovieShowsResponseModel> getMovieShowsList() {
		return movieShowsList;
	}
	
	
	
	
	
	

}
