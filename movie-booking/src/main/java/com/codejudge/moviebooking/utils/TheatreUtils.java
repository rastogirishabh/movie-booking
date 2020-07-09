package com.codejudge.moviebooking.utils;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codejudge.moviebooking.dao.TheatreRepository;
import com.codejudge.moviebooking.entity.TheatreEntity;

@Service
public class TheatreUtils {
	
	@Autowired
	TheatreRepository theatreRepository;


	public String generateTheatreId(String theatre_name, String city) {
		
		String [] theatreNameArr = theatre_name.split(" ");
		if(theatreNameArr.length<2)
		{
			return theatre_name.concat(city);
		}
		else
		{
			String theatre_id="";
			for(int i =theatreNameArr.length-1; i>=0; i--)
			{
				theatre_id = theatreNameArr[i].concat(theatre_id);
			}
			return theatre_id.concat(city);
		}
		
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

	public boolean isTheatreRegistered(String theatre_id) {
		return theatreRepository.existsById(theatre_id);
		
	}
	
	public Optional<TheatreEntity> findTheatrebyId(String theatre_id) {
		return theatreRepository.findById(theatre_id);
	}

}
