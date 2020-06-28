package com.codejudge.moviebooking.service;

import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codejudge.moviebooking.dao.TemporaryRepository;
import com.codejudge.moviebooking.exceptions.MovieDoesNotExistsException;
import com.codejudge.moviebooking.exceptions.TheatreDoesNotExistsException;
import com.codejudge.moviebooking.exceptions.TheatreNotAvailableException;
import com.codejudge.moviebooking.requestmodel.MovieShowsRequestModel;
import com.codejudge.moviebooking.responsemodel.MovieShowsResponseModel;
import com.codejudge.moviebooking.responsemodel.ShowsResponseHelper;
import com.codejudge.moviebooking.utils.MovieShowsUtils;

@Service
public class MovieShowsServiceImpl implements MovieShowsService {
	@Autowired
	MovieShowsUtils movieShowsUtils;

	@Autowired
	TemporaryRepository database;

	@Autowired
	ShowsResponseHelper showsResponseHelper;

	@Autowired
	MovieShowsResponseModel createdMovieShow;

	@Override
	public MovieShowsResponseModel createMovieShows(MovieShowsRequestModel movieShowsInputDetails) {

		System.out.println("Current Shows : " + database.getMovieShowsList());

		if(!movieShowsUtils.isMovieExist(movieShowsInputDetails.getMovie_id(),database.getMovieList()))	{
			throw new MovieDoesNotExistsException("No movie is available with movie id : " + movieShowsInputDetails.getMovie_id());
		}

		if(!movieShowsUtils.isTheatreExist(movieShowsInputDetails.getTheatre_id(),database.getTheatreList())) {
			throw new TheatreDoesNotExistsException("No Theatre is available with Theatre id : " + movieShowsInputDetails.getTheatre_id());
		}

		if(movieShowsUtils.isTheatreAvailable(movieShowsInputDetails.getDate(),movieShowsInputDetails.getTime(),movieShowsInputDetails.getTheatre_id(), database.getMovieShowsList())) {
			throw new TheatreNotAvailableException("Another movie show is running at theatre ID : " + movieShowsInputDetails.getTheatre_id() + 
					" in the requested slot");
		}

		BeanUtils.copyProperties(movieShowsInputDetails, showsResponseHelper);

		createdMovieShow.setShows(showsResponseHelper);

		createdMovieShow.setMovies(database.getMovieList()
				.stream()
				.filter(movies->movies.getMovie_id()==movieShowsInputDetails.getMovie_id())
				.collect(Collectors.toList())
				.get(0));
		createdMovieShow.setTheatre(database.getTheatreList()
				.stream()
				.filter(theatre->theatre.getTheatre_id()==movieShowsInputDetails.getTheatre_id())
				.collect(Collectors.toList())
				.get(0));

		database.movieShowsList.add(createdMovieShow);

		System.out.println("Movie Show Created : " + createdMovieShow);

		System.out.println("Updated List : " + database.getMovieShowsList());
		return createdMovieShow;
	}

}
