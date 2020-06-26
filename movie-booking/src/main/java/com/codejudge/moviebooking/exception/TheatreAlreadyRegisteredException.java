package com.codejudge.moviebooking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TheatreAlreadyRegisteredException extends RuntimeException {

	private static final long serialVersionUID = -8384885532841185782L;
	
	public TheatreAlreadyRegisteredException(String message) {
		super(message);
	}


}
