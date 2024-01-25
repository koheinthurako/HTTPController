package com.httpControllerTest.HttpController.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.annotation.Configuration;

import com.httpControllerTest.HttpController.movieEntity.Movie;
import com.httpControllerTest.HttpController.service.Movie_Service;

@Configuration
public class Movie_Service_Impl implements Movie_Service {

	List<Movie> movieCollection = new ArrayList<Movie>();

	public Movie_Service_Impl() {
		movieCollection.add(new Movie(1, "Interstellar", "English", "Adventure"));
	}
	
	@Override
	public Movie getById(int id) {
		for(Movie movie : movieCollection) {
			if(movie.getId()==id) {
				return movie;
			}
		}
		return null;
	}

	@Override
	public List<Movie> getAllMovies() {
		return movieCollection;
	}

	@Override
	public Movie addNewMovie(Movie movie) {
		Movie newMovie = new Movie();
		newMovie.setId(movieCollection.size() + 1);
		newMovie.setName(movie.getName());
		newMovie.setLanguage(movie.getLanguage());
		newMovie.setType(movie.getType());
		movieCollection.add(newMovie);
		return newMovie;
	}

	@Override
	public Movie updateInfo(int id, Movie movie) {
		for (Movie newMov : movieCollection) {
			if (id == newMov.getId()) {
				newMov.setName(movie.getName());
				newMov.setLanguage(movie.getLanguage());
				newMov.setType(movie.getType());
			}
		}
		return movieCollection.get(id - 1);
	}

	
	@Override
	public String deleteMovie(int id) {
		Iterator<Movie> movieList = movieCollection.iterator();
		while(movieList.hasNext()) {
			Movie pointer = movieList.next();
			if(pointer.getId()==id) {
				movieList.remove();
//				loop inner to change other movies' id
				while(movieList.hasNext()) {
					Movie newPointer = movieList.next();
					newPointer.setId(newPointer.getId()-1);
				}
			}
		}
		return "Deleted!";
	}

}
