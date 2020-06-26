package com.codejudge.moviebooking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TheatreNotAvailableException extends RuntimeException {

	private static final long serialVersionUID = 9184294928202371238L;
	
	public TheatreNotAvailableException(String message) {
		super(message);
	}
	

}
