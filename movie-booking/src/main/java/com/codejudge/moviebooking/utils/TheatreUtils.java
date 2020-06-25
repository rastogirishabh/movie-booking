package com.codejudge.moviebooking.utils;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.codejudge.moviebooking.requestmodel.TheatreRequestModel;
import com.codejudge.moviebooking.responsemodel.TheatreResponseModel;

@Service
public class TheatreUtils {

	public int generateTheatreId() {
		return new Random().nextInt(20);		
		/*
		 * Random randomNumber = new Random();
		 * 
		 * StringBuilder uniqueId = new StringBuilder();
		 * 
		 * return uniqueId.append(theatreInputDetails.getTheatre_name()) .append("_")
		 * .append(theatreInputDetails.getCity())
		 * .append(randomNumber.nextInt(20)).toString();
		 */
		}

	public boolean isTheatreRegistered(String theatre_name, String city, List<TheatreResponseModel> theatreList) {
		if(!theatreList.stream()
				.filter(theatre -> theatre.getTheatre_name().equalsIgnoreCase(theatre_name) && 
				theatre.getCity().equalsIgnoreCase(city))
				.collect(Collectors.toList()).isEmpty())
			return true;
		
		return false;
	}

}
