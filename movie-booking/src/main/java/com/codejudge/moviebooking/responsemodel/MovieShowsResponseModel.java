package com.codejudge.moviebooking.responsemodel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.codejudge.moviebooking.entity.MovieEntity;
import com.codejudge.moviebooking.entity.Shows;
import com.codejudge.moviebooking.entity.TheatreEntity;

@Repository
public class MovieShowsResponseModel {
	private MovieEntity movies;
	
	private TheatreEntity theatre;

	@Autowired
	List<Shows> shows;

	public MovieEntity getMovies() {
		return movies;
	}

	public void setMovies(MovieEntity movies) {
		this.movies = movies;
	}

	public TheatreEntity getTheatre() {
		return theatre;
	}

	public void setTheatre(TheatreEntity theatre) {
		this.theatre = theatre;
	}

	
	public List<Shows> getShows() {
		return shows;
	}

	public void setShows(List<Shows> showsList) {
		this.shows = showsList;
	}

	@Override
	public String toString() {
		return "MovieShowsResponseModel [movies=" + movies + ", theatre=" + theatre + ", showsList=" + shows + "]";
	}

	

	
	
	
}
