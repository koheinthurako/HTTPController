package com.httpControllerTest.HttpController.service;

import java.util.List;

import com.httpControllerTest.HttpController.movieEntity.Movie;

public interface Movie_Service {

	public List<Movie> getAllMovies();
	public Movie addNewMovie(Movie movie);
	public Movie updateInfo(int id, Movie movie);
	public String deleteMovie(int id);
	
}
