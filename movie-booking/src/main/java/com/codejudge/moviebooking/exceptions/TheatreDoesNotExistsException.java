package com.codejudge.moviebooking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TheatreDoesNotExistsException extends RuntimeException {
	
	private static final long serialVersionUID = -3148732389544223632L;
	

	public TheatreDoesNotExistsException(String message) {
		super(message);
	}

}
