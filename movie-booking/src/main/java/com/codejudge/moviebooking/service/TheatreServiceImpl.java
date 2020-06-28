package com.codejudge.moviebooking.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codejudge.moviebooking.dao.TemporaryRepository;
import com.codejudge.moviebooking.exceptions.TheatreAlreadyRegisteredException;
import com.codejudge.moviebooking.requestmodel.TheatreRequestModel;
import com.codejudge.moviebooking.responsemodel.TheatreResponseModel;
import com.codejudge.moviebooking.utils.TheatreUtils;

@Service
public class TheatreServiceImpl implements TheatreService {
	@Autowired
	TheatreUtils theatreUtils;
	
	@Autowired
	TheatreResponseModel theatreAdded; 

	@Autowired
	TemporaryRepository database;

	@Override
	public TheatreResponseModel addTheatre(TheatreRequestModel theatreInputDetails) {
		System.out.println("Current Theatres : " + database.getTheatreList());
		
		if(theatreUtils.isTheatreRegistered(theatreInputDetails.getTheatre_name(), theatreInputDetails.getCity(), database.getTheatreList())) {
			throw new TheatreAlreadyRegisteredException("Theatre with name : " 
		+theatreInputDetails.getTheatre_name() + " already registered in city : " + theatreInputDetails.getCity()); 
		}
		BeanUtils.copyProperties(theatreInputDetails, theatreAdded);
		theatreAdded.setTheatre_id(theatreUtils.generateTheatreId());
		
		database.theatreList.add(theatreAdded);
		
		System.out.println("New Theatre added : " + database.getTheatreList());
		
		return theatreAdded;
	}

}
