package com.codejudge.moviebooking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DateTimeFormateNotValidException extends RuntimeException {

	private static final long serialVersionUID = 1864117108258994906L;


	public DateTimeFormateNotValidException(String messages) {
		super(messages);
	}

}
