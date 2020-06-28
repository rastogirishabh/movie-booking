package com.codejudge.moviebooking.responsemodel;


import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Repository;

@Repository
public class ShowsResponseHelper {

	private LocalDate date;
	
	private LocalTime time;
	
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
		return "ShowsResponseModel [date=" + date + ", time=" + time + "]";
	}
	
	
	

}
