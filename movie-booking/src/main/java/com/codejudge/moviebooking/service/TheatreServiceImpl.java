package com.codejudge.moviebooking.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codejudge.moviebooking.dao.TheatreRepository;
import com.codejudge.moviebooking.entity.TheatreEntity;
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
	TheatreRepository theatreRepository;

	@Override
	public TheatreEntity addTheatre(TheatreRequestModel theatreInputDetails) {
		
		String theatre_id = theatreUtils.generateTheatreId(theatreInputDetails.getTheatre_name(), theatreInputDetails.getCity());
		
		if(theatreUtils.isTheatreRegistered(theatre_id)) {
			throw new TheatreAlreadyRegisteredException("Theatre with name : " +theatreInputDetails.getTheatre_name() 
			+ " already registered in city : " + theatreInputDetails.getCity()); 
		}
		
		TheatreEntity theatreAdded = new TheatreEntity();
		BeanUtils.copyProperties(theatreInputDetails, theatreAdded);
		theatreAdded.setTheatre_id(theatre_id);
		
		theatreAdded = theatreRepository.save(theatreAdded);
		
		System.out.println("New Theatre added : " + theatreAdded);
		
		return theatreAdded;
	}

}
