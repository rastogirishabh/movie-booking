package com.codejudge.moviebooking.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codejudge.moviebooking.dao.MovieShowsRepository;
import com.codejudge.moviebooking.entity.MovieEntity;
import com.codejudge.moviebooking.entity.MovieShowsEntity;
import com.codejudge.moviebooking.entity.Shows;
import com.codejudge.moviebooking.entity.TheatreEntity;
import com.codejudge.moviebooking.requestmodel.MovieShowsRequestModel;
import com.codejudge.moviebooking.responsemodel.MovieShowsResponseModel;
import com.codejudge.moviebooking.utils.MovieShowsUtils;
import com.codejudge.moviebooking.utils.MovieUtils;
import com.codejudge.moviebooking.utils.TheatreUtils;

@Service
public class MovieShowsServiceImpl implements MovieShowsService {
	@Autowired
	MovieShowsUtils movieShowsUtils;

	@Autowired
	TheatreUtils theatreUtils;

	@Autowired
	MovieUtils movieUtils;

	@Autowired
	MovieShowsRepository movieShowsRepository;
	
	/*
	 * @Autowired MovieShowsResponseModel createdMovieShow;
	 */
	@Autowired
	Shows shows;

	@Override
	public MovieShowsResponseModel createMovieShows(MovieShowsRequestModel movieShowsInputDetails) {
		
		System.out.println("MovieShowInputDetails : " + movieShowsInputDetails);
		
		if(movieShowsUtils.isMovieShowPossible(movieShowsInputDetails)) {
			
			MovieShowsEntity newMovieShow = new MovieShowsEntity();
			BeanUtils.copyProperties(movieShowsInputDetails, newMovieShow);

			newMovieShow = movieShowsRepository.save(newMovieShow);
			
			MovieShowsResponseModel createdMovieShow = new MovieShowsResponseModel();
			
			Optional<MovieEntity> movie = movieUtils.findMovieById(movieShowsInputDetails.getMovie_id());
			if(movie.isPresent())
				createdMovieShow.setMovies(movie.get());
			
			Optional<TheatreEntity> theatre = theatreUtils.findTheatrebyId(movieShowsInputDetails.getTheatre_id());
			if(theatre.isPresent())
				createdMovieShow.setTheatre(theatre.get());
			
			shows.setDate(newMovieShow.getDate());
			shows.setTime(newMovieShow.getTime());
			
			List<Shows> showsList = new ArrayList<>();
			showsList.add(shows);
			
			createdMovieShow.setShows(showsList);
			
			System.out.println("New movie show created : " + createdMovieShow);
			
			return createdMovieShow;
		}
		return null;

		
	}

	@Override
	public MovieShowsResponseModel getMovieShowsByCityAndDate(String movie_id, String city, LocalDate showDate) {
		
		return null;
	}

}
