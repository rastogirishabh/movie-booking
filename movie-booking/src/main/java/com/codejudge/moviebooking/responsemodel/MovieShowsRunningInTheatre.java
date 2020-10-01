package com.codejudge.moviebooking.responsemodel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.codejudge.moviebooking.entity.Shows;
import com.codejudge.moviebooking.entity.TheatreEntity;

public class MovieShowsRunningInTheatre {
	private TheatreEntity theatre;
	
	@Autowired
	private List<Shows> showsList;

	public TheatreEntity getTheatre() {
		return theatre;
	}

	public void setTheatre(TheatreEntity theatre) {
		this.theatre = theatre;
	}

	public List<Shows> getShowsList() {
		return showsList;
	}

	public void setShowsList(List<Shows> showsList) {
		this.showsList = showsList;
	}

	@Override
	public String toString() {
		return "MovieShowsRunningInTheatre [theatre=" + theatre + ", showsList=" + showsList + "]";
	}

	public MovieShowsRunningInTheatre() {
		super();
	}
	
	

}
