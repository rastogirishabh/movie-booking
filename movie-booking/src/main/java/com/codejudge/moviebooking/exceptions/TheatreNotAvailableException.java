package com.codejudge.moviebooking.exceptions;

public class TheatreNotAvailableException extends RuntimeException {

	private static final long serialVersionUID = 9184294928202371238L;
	
	public TheatreNotAvailableException(String message) {
		super(message);
	}
	

}
