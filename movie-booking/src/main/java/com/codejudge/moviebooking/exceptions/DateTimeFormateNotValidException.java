package com.codejudge.moviebooking.exceptions;

public class DateTimeFormateNotValidException extends RuntimeException {

	private static final long serialVersionUID = 1864117108258994906L;


	public DateTimeFormateNotValidException(String messages) {
		super(messages);
	}

}
