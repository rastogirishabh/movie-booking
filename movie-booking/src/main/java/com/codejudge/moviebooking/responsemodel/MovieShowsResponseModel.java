package com.codejudge.moviebooking.responsemodel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MovieShowsResponseModel {
	@Autowired
	private MovieResponseModel movies;
	
	@Autowired
	private TheatreResponseModel theatre;
	
	@Autowired
	ShowsResponseHelper showsResponseHelper;

	public MovieResponseModel getMovies() {
		return movies;
	}

	public void setMovies(MovieResponseModel movies) {
		this.movies = movies;
	}

	public TheatreResponseModel getTheatre() {
		return theatre;
	}

	public void setTheatre(TheatreResponseModel theatre) {
		this.theatre = theatre;
	}

	public ShowsResponseHelper getShows() {
		return showsResponseHelper;
	}

	public void setShows(ShowsResponseHelper showsResponseHelper) {
		this.showsResponseHelper = showsResponseHelper;
	}

	@Override
	public String toString() {
		return "MovieShowsResponseModel [movies=" + movies + ", theatre=" + theatre + ", shows=" + showsResponseHelper + "]";
	}
	
	
	
}
