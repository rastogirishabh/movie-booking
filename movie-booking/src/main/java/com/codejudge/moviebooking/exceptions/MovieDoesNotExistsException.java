package com.codejudge.moviebooking.exceptions;

public class MovieDoesNotExistsException extends RuntimeException {

	private static final long serialVersionUID = 5580086767813859065L;
	
	public MovieDoesNotExistsException(String message) {
		super(message);
	}


}
