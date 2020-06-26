package com.codejudge.moviebooking.responsemodel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.codejudge.moviebooking.entity.Shows;

@Repository
public class MovieShowsResponseModel {
	@Autowired
	private MovieResponseModel movies;
	
	@Autowired
	private TheatreResponseModel theatre;
	
	@Autowired
	Shows shows;

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

	public Shows getShows() {
		return shows;
	}

	public void setShows(Shows shows) {
		this.shows = shows;
	}

	@Override
	public String toString() {
		return "MovieShowsResponseModel [movies=" + movies + ", theatre=" + theatre + ", shows=" + shows + "]";
	}
	
	
	
}
