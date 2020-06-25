package com.codejudge.moviebooking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MovieServiceErrorAdvice extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(MovieAlreadyPresentException.class)
	public ResponseEntity<ExceptionResponse> handleMovieAlreadyPresentException(MovieAlreadyPresentException exception, WebRequest request)
	{
		ExceptionResponse exceptionResponse = new ExceptionResponse("Failure","Movie Already Present with " + exception.getMessage());
		
		return new ResponseEntity<ExceptionResponse> (exceptionResponse, HttpStatus.BAD_REQUEST); 
	}

}
