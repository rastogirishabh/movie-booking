package com.codejudge.moviebooking.utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codejudge.moviebooking.responsemodel.MovieResponseModel;
import com.codejudge.moviebooking.responsemodel.MovieShowsResponseModel;
import com.codejudge.moviebooking.responsemodel.TheatreResponseModel;

@Service
public class MovieShowsUtils {

	public boolean isMovieExist(int movie_id, List<MovieResponseModel> movieRepository) {
		System.out.println("MovieRepo : " + movieRepository);
		return movieRepository.stream()
				.anyMatch(movie -> movie.getMovie_id()==movie_id);
	}

	public boolean validateDateTimeFormats(LocalDate showDate, LocalTime showTime) {
		
		return true;
	}

	public boolean isTheatreExist(int theatre_id, List<TheatreResponseModel> theatreRepository) {
		System.out.println("TheatreRepo : " + theatreRepository);
		return theatreRepository.stream()
				.anyMatch(theatre -> theatre.getTheatre_id() == theatre_id);
	}

	public boolean isTheatreAvailable(LocalDate date, LocalTime time, int theatre_id, List<MovieShowsResponseModel> movieShowsRepository) {
		System.out.println("MovieShowsRepo : " + movieShowsRepository);
		return movieShowsRepository.stream()
				.anyMatch(movieShows->movieShows.getShows().getDate().equals(date)
						&& movieShows.getShows().getTime().equals(time)
						&& movieShows.getTheatre().getTheatre_id()==theatre_id);
		
	}

	

}
