package com.codejudge.moviebooking.requestmodel;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;


public class MovieShowsRequestModel {
	
	private String theatre_id;
	
	private String movie_id;
	
	@JsonFormat(pattern ="yyyy/MM/dd")
	private LocalDate date;
	
	@JsonFormat(pattern = "HH:mm:ss")
	private LocalTime time;

	public MovieShowsRequestModel() {
		System.out.println("--MovieShowsRequestModel Bean created--");
	}
	public String getTheatre_id() {
		return theatre_id;
	}
	
	public void setTheatre_id(String theatre_id) {
		this.theatre_id = theatre_id;
	}

	public String getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(String movie_id) {
		this.movie_id = movie_id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "MovieShowsRequestModel [theatre_id=" + theatre_id + ", movie_id=" + movie_id + ", date=" + date
				+ ", time=" + time + "]";
	}

	
	
	
	

}
