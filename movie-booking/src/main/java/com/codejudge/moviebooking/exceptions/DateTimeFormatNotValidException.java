package com.codejudge.moviebooking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DateTimeFormatNotValidException extends RuntimeException {

	private static final long serialVersionUID = 1864117108258994906L;


	public DateTimeFormatNotValidException(String messages) {
		super(messages);
	}

}
