package com.codejudge.moviebooking.requestmodel;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

public class MovieShowsRequestModel {
	
	
	private int theatre_id;
	
	private int movie_id;
	
	@DateTimeFormat(pattern ="yyyy/MM/dd")
	private LocalDate date;
	
	@DateTimeFormat(pattern = "HH:mm:ss")
	private LocalTime time;

	public int getTheatre_id() {
		return theatre_id;
	}

	public void setTheatre_id(int theatre_id) {
		this.theatre_id = theatre_id;
	}

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
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
