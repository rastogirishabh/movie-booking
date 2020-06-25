package com.codejudge.moviebooking.requestmodel;

import org.springframework.stereotype.Repository;

@Repository
public class MovieRequestModel {
	
	private String movie_name;
	
	private String movie_trailer;
	
	private String movie_overview;
	
	private String movie_poster;
	
	private int length;

	public String getMovie_name() {
		return movie_name;
	}

	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}

	public String getMovie_trailer() {
		return movie_trailer;
	}

	public void setMovie_trailer(String movie_trailer) {
		this.movie_trailer = movie_trailer;
	}

	public String getMovie_overview() {
		return movie_overview;
	}

	public void setMovie_overview(String movie_overview) {
		this.movie_overview = movie_overview;
	}

	public String getMovie_poster() {
		return movie_poster;
	}

	public void setMovie_poster(String movie_poster) {
		this.movie_poster = movie_poster;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	@Override
	public String toString() {
		return "MovieRequestModel [movie_name=" + movie_name + ", movie_trailer=" + movie_trailer + ", movie_overview="
				+ movie_overview + ", movie_poster=" + movie_poster + ", length=" + length + "]";
	}
	

}
