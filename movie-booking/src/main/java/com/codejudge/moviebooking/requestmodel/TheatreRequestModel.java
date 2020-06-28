package com.codejudge.moviebooking.requestmodel;

import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Repository;

@Repository
public class TheatreRequestModel {
	
	@NotEmpty(message = "theatre_name is required")
	private String theatre_name;
	
	@NotEmpty(message = "theatre_location is required")
	private String theatre_location;
	
	private String city;
	
	private int pincode;

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

	@Override
	public String toString() {
		return "TheatreRequestModel [theatre_name=" + theatre_name + ", theatre_location=" + theatre_location
				+ ", city=" + city + ", pincode=" + pincode + "]";
	}
	
	

}
