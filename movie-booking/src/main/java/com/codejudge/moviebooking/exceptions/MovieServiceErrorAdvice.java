package com.codejudge.moviebooking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.codejudge.moviebooking.service.TheatreAlreadyRegisteredException;

@ControllerAdvice
public class MovieServiceErrorAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(MovieAlreadyPresentException.class)
	public ResponseEntity<ExceptionResponse> handleMovieAlreadyPresentException(MovieAlreadyPresentException exception, WebRequest request)
	{
		ExceptionResponse exceptionResponse = new ExceptionResponse("failure","Movie Already Present with " + exception.getMessage());

		return new ResponseEntity<ExceptionResponse> (exceptionResponse, HttpStatus.BAD_REQUEST); 
	}

	@ExceptionHandler(TheatreAlreadyRegisteredException.class)
	public ResponseEntity<ExceptionResponse> handleTheatreAlreadyRegisteredException(TheatreAlreadyRegisteredException exception, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse("failure",exception.getMessage());

		return new ResponseEntity<ExceptionResponse> (exceptionResponse, HttpStatus.BAD_REQUEST); 

	}

}
