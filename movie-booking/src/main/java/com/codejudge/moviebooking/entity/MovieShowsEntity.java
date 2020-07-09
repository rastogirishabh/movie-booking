package com.codejudge.moviebooking.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Movie_Shows_Master")
public class MovieShowsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long show_id;
	
	private String theatre_id;

	private String movie_id;

	private LocalDate date;

	private LocalTime time;


	public MovieShowsEntity() {
		super();
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


	public Long getShow_id() {
		return show_id;
	}


	public void setShow_id(Long show_id) {
		this.show_id = show_id;
	}


	@Override
	public String toString() {
		return "MovieShowsEntity [show_id=" + show_id + ", theatre_id=" + theatre_id + ", movie_id=" + movie_id
				+ ", date=" + date + ", time=" + time + "]";
	}


}
