package com.codejudge.moviebooking.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codejudge.moviebooking.dao.MovieRepository;
import com.codejudge.moviebooking.dao.MovieShowsRepository;
import com.codejudge.moviebooking.dao.TheatreRepository;
import com.codejudge.moviebooking.entity.MovieEntity;
import com.codejudge.moviebooking.entity.MovieShowsEntity;
import com.codejudge.moviebooking.entity.Shows;
import com.codejudge.moviebooking.entity.TheatreEntity;
import com.codejudge.moviebooking.exceptions.MovieDoesNotExistsException;
import com.codejudge.moviebooking.exceptions.NoTheatresInCityException;
import com.codejudge.moviebooking.exceptions.TheatreDoesNotExistsException;
import com.codejudge.moviebooking.requestmodel.MovieShowsRequestModel;
import com.codejudge.moviebooking.responsemodel.MovieShowsResponseModel;
import com.codejudge.moviebooking.responsemodel.MovieShowsRunningInTheatre;
import com.codejudge.moviebooking.responsemodel.MoviesRunningInCityResponseModel;
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
	
	@Autowired
	TheatreRepository theatreRepository;
	
	@Autowired
	MovieRepository movieRepository;

	
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
	public MoviesRunningInCityResponseModel getMovieShowsByCityAndDate(String movie_id, String city, LocalDate showDate) {
		System.out.println("--getMovieShowsByCityAndDate--");
		if(!movieUtils.isMoviePresent(movie_id))  
			throw new MovieDoesNotExistsException("No movie is available with movie id : " + movie_id); 
		
		List<String> theatresInACity = theatreRepository.findAllTheatreByCity(city);
		if(theatresInACity.isEmpty())
			throw new NoTheatresInCityException("No theatres exists in city : " + city);
		
		MoviesRunningInCityResponseModel movieRunningInCity = new MoviesRunningInCityResponseModel();
		Optional<MovieEntity> movieEntity = movieRepository.findById(movie_id);
		if(movieEntity.isPresent())
			movieRunningInCity.setMovie(movieEntity.get());
		
		
		System.out.println("All theatres in a city : " + theatresInACity);
		
		List<MovieShowsRunningInTheatre> movieShowsRunningInTheatre = new ArrayList<>();
	
		
		theatresInACity.parallelStream().forEach(theatre->{
			System.out.println("For Theatre : " + theatre);
			movieShowsRunningInTheatre.add(getMovieShowsByTheatreIdAndDate(theatre, showDate));
			System.out.println("MovieShowsByTheatreIdAndDate : " + movieShowsRunningInTheatre);
		});
	
		movieRunningInCity.setTheatres(movieShowsRunningInTheatre);
		
		System.out.println("--> MoviesRunningInCityResponseModel <-- \n" + movieRunningInCity);
		
		return movieRunningInCity;
		
	}

	@Override
	public MovieShowsRunningInTheatre getMovieShowsByTheatreId(String theatre_id) {
		System.out.println("--getMovieShowsByTheatreId--");
		if(!theatreUtils.isTheatreRegistered(theatre_id)) {
			throw new TheatreDoesNotExistsException("No Theatre is available with Theatre id : " + theatre_id);
		}
		
		MovieShowsRunningInTheatre allShowsRunningInTheatre = new MovieShowsRunningInTheatre();
		
		Optional<TheatreEntity> theatreEntity = theatreRepository.findById(theatre_id);
		if(theatreEntity.isPresent()) {
			BeanUtils.copyProperties(theatreEntity.get(), allShowsRunningInTheatre);
		}
		System.out.println("--theatre Entity : " + theatreEntity);
		List<MovieShowsEntity> movieShowsEntity = movieShowsRepository.findByTheatreId(theatre_id);
		System.out.print("Shows obtained from DB : " + movieShowsEntity);
		
		List<Shows> showsList = new ArrayList<>();
		
		movieShowsEntity.parallelStream().forEach(movieShow->{ 
			shows.setDate(movieShow.getDate());
			shows.setTime(movieShow.getTime());
			showsList.add(shows);
		});
		
		allShowsRunningInTheatre.setShows(showsList);
		return allShowsRunningInTheatre;
	}
	
	public MovieShowsRunningInTheatre getMovieShowsByTheatreIdAndDate(String theatre_id, LocalDate date) {
		System.out.println("--getMovieShowsByTheatreId--");
		if(!theatreUtils.isTheatreRegistered(theatre_id)) {
			throw new TheatreDoesNotExistsException("No Theatre is available with Theatre id : " + theatre_id);
		}
		
		MovieShowsRunningInTheatre allShowsRunningInTheatre = new MovieShowsRunningInTheatre();
		
		Optional<TheatreEntity> theatreEntity = theatreRepository.findById(theatre_id);
		if(theatreEntity.isPresent()) {
			BeanUtils.copyProperties(theatreEntity.get(), allShowsRunningInTheatre);
		}
		System.out.println("--theatre Entity : " + theatreEntity);
		List<MovieShowsEntity> movieShowsEntity = movieShowsRepository.findByTheatreIdAndDate(theatre_id,date);
		System.out.print("Shows obtained from DB : " + movieShowsEntity);
		
		List<Shows> showsList = new ArrayList<>();
		
		movieShowsEntity.parallelStream().forEach(movieShow->{ 
			shows.setDate(movieShow.getDate());
			shows.setTime(movieShow.getTime());
			showsList.add(shows);
		});
		
		allShowsRunningInTheatre.setShows(showsList);
		return allShowsRunningInTheatre;
	}
	
	

}
