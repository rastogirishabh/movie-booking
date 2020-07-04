package com.codejudge.moviebooking.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Theatre_Master")
public class TheatreEntity {
	
	@Id
	private String theatre_id;

	private String theatre_name;

	private String theatre_location;

	private String city;

	private int pincode;

	public TheatreEntity() {
		super();
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

	public String getTheatre_id() {
		return theatre_id;
	}

	public void setTheatre_id(String theatre_id) {
		this.theatre_id = theatre_id;
	}
	
	@Override
	public String toString() {
		return "TheatreResponseModel [theatre_id=" + theatre_id + ", theatre_name=" + theatre_name
				+ ", theatre_location=" + theatre_location + ", city=" + city + ", pincode=" + pincode + "]";
	}

}
