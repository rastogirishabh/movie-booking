package com.codejudge.moviebooking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codejudge.moviebooking.requestmodel.TheatreRequestModel;
import com.codejudge.moviebooking.responsemodel.TheatreResponseModel;
import com.codejudge.moviebooking.utils.TheatreUtils;

@Service
public class TheatreServiceImpl implements TheatreService {
	@Autowired
	TheatreUtils theatreUtils;
	
	private List<TheatreResponseModel> theatreList = new ArrayList<>();

	@Override
	public TheatreResponseModel addTheatre(TheatreRequestModel theatreInputDetails) {
		
		TheatreResponseModel theatreAdded = new TheatreResponseModel();
		
		if(theatreUtils.isTheatreRegistered(theatreInputDetails.getTheatre_name(), theatreInputDetails.getCity(), theatreList)) {
			throw new TheatreAlreadyRegisteredException("Theatre with name : " 
		+theatreInputDetails.getTheatre_name() + " already registered in city : " + theatreInputDetails.getCity()); 
		}
		BeanUtils.copyProperties(theatreInputDetails, theatreAdded);
		theatreAdded.setTheatre_id(theatreUtils.generateTheatreId());
		
		theatreList.add(theatreAdded);
		
		return theatreAdded;
	}

}
