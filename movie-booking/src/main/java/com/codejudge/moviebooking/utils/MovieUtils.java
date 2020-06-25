package com.codejudge.moviebooking.utils;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.codejudge.moviebooking.responsemodel.MovieResponseModel;

@Service
public class MovieUtils {

	public boolean isMoviePresent(String movie_name, List<MovieResponseModel> movieList) {
		if(!movieList.stream()
				.filter(movie -> movie.getMovie_name().equalsIgnoreCase(movie_name))
				.collect(Collectors.toList())
				.isEmpty()) {
			System.out.println("--Movie Already Present--");
			return true;
		}
		return false;
	}

	public String generateMovieID(String movie_name) {
		return movie_name.concat(String.valueOf(new Random().nextInt(20)));
	}

}
