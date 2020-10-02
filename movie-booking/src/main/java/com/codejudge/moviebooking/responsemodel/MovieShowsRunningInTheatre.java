package com.codejudge.moviebooking.responsemodel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.codejudge.moviebooking.entity.Shows;

public class MovieShowsRunningInTheatre {
	
	private String theatre_id;

	private String theatre_name;

	private String theatre_location;

	private String city;

	private int pincode;
	
	@Autowired
	private List<Shows> shows;
	
	public List<Shows> getShows() {
		return shows;
	}

	public void setShows(List<Shows> shows) {
		this.shows = shows;
	}

	public String getTheatre_id() {
		return theatre_id;
	}

	public void setTheatre_id(String theatre_id) {
		this.theatre_id = theatre_id;
	}

	public String getTheatre_name() {
		return theatre_name;
	}

	public void setTheatre_name(String theatre_name) {
		this.theatre_name = theatre_name;
	}

	public String getTheatre_location() {
		return theatre_location;
	}

	public void setTheatre_location(String theatre_location) {
		this.theatre_location = theatre_location;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public MovieShowsRunningInTheatre() {
		super();
	}

	@Override
	public String toString() {
		return "MovieShowsRunningInTheatre [theatre_id=" + theatre_id + ", theatre_name=" + theatre_name
				+ ", theatre_location=" + theatre_location + ", city=" + city + ", pincode=" + pincode + ", shows="
				+ shows + "]";
	}
	
	
	
	

}
