package com.codejudge.moviebooking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MovieDoesNotExistsException extends RuntimeException {

	private static final long serialVersionUID = 5580086767813859065L;
	
	public MovieDoesNotExistsException(String message) {
		super(message);
	}


}
