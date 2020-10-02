package com.codejudge.moviebooking.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalErrorAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(MovieAlreadyPresentException.class)
	public ResponseEntity<ExceptionResponse> handleMovieAlreadyPresent(MovieAlreadyPresentException exception, 
			WebRequest request)
	{
		ExceptionResponse exceptionResponse = new ExceptionResponse("failure","Movie Already Present with " + exception.getMessage());

		return new ResponseEntity<ExceptionResponse> (exceptionResponse, HttpStatus.BAD_REQUEST); 
	}

	@ExceptionHandler(TheatreAlreadyRegisteredException.class)
	public ResponseEntity<ExceptionResponse> handleTheatreAlreadyRegistered(TheatreAlreadyRegisteredException exception, 
			WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse("failure",exception.getMessage());

		return new ResponseEntity<ExceptionResponse> (exceptionResponse, HttpStatus.BAD_REQUEST); 

	}

	@ExceptionHandler(MovieDoesNotExistsException.class)
	public ResponseEntity<ExceptionResponse> handleMovieDoesNotExists(MovieDoesNotExistsException exception, 
			WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse("failure",exception.getMessage());

		return new ResponseEntity<ExceptionResponse> (exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(TheatreDoesNotExistsException.class)
	public ResponseEntity<ExceptionResponse> handleTheatreDoesNotExists(TheatreDoesNotExistsException exception, 
			WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse("failure",exception.getMessage());

		return new ResponseEntity<ExceptionResponse> (exceptionResponse, HttpStatus.BAD_REQUEST); 
	}

	@ExceptionHandler(DateTimeFormatNotValidException.class)
	public ResponseEntity<ExceptionResponse> handleDateTimeFormateNotValid(DateTimeFormatNotValidException exception, 
			WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse("failure",exception.getMessage());

		return new ResponseEntity<ExceptionResponse> (exceptionResponse, HttpStatus.BAD_REQUEST); 
	}

	@ExceptionHandler(TheatreNotAvailableException.class)
	public ResponseEntity<ExceptionResponse> handleTheatreNotAvailable(TheatreNotAvailableException exception, 
			WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse("failure",exception.getMessage());

		return new ResponseEntity<ExceptionResponse> (exceptionResponse, HttpStatus.BAD_REQUEST); 
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		ExceptionResponse exceptionResponse;
		System.out.println("Could not validate : " + exception.getBindingResult().getFieldError().getField());

			exceptionResponse = new ExceptionResponse("failure",exception
					.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<> (exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoTheatresInCityException.class)
	public ResponseEntity<ExceptionResponse> handleNoTheatreInCity(NoTheatresInCityException exception, WebRequest request) {
		
		ExceptionResponse exceptionResponse = new ExceptionResponse("failure",exception.getMessage());

		return new ResponseEntity<ExceptionResponse> (exceptionResponse, HttpStatus.BAD_REQUEST); 
	}
	
}
