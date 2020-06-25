package com.codejudge.moviebooking.exceptions;

public class TheatreDoesNotExistsException extends RuntimeException {
	
	private static final long serialVersionUID = -3148732389544223632L;
	

	public TheatreDoesNotExistsException(String message) {
		super(message);
	}

}
