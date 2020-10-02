package com.codejudge.moviebooking.responsemodel;

import java.util.List;

import com.codejudge.moviebooking.entity.MovieEntity;

public class MoviesRunningInCityResponseModel {
	
	private MovieEntity movie;
	
	private List<MovieShowsRunningInTheatre> theatres;

	public MovieEntity getMovie() {
		return movie;
	}

	public void setMovie(MovieEntity movieEntity) {
		this.movie = movieEntity;
	}

	public List<MovieShowsRunningInTheatre> getTheatres() {
		return theatres;
	}

	public void setTheatres(List<MovieShowsRunningInTheatre> showsRunningInTheatre) {
		this.theatres = showsRunningInTheatre;
	}

	
	@Override
	public String toString() {
		return "MoviesRunningInCityResponseModel [movieEntity=" + movie + ", theatres=" + theatres + "]";
	}

	public MoviesRunningInCityResponseModel() {
		super();
	}
	
	

}
