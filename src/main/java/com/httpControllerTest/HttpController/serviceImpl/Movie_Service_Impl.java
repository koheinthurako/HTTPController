package com.httpControllerTest.HttpController.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;

import com.httpControllerTest.HttpController.movieEntity.Movie;
import com.httpControllerTest.HttpController.service.Movie_Service;

@Configuration
public class Movie_Service_Impl implements Movie_Service{
	
	List<Movie> movieCollection = new ArrayList<Movie>();
	
	public Movie_Service_Impl() {
		movieCollection.add(new Movie(1, "Interstellar", "English", "Adventure"));
	}
	

	@Override
	public List<Movie> getAllMovies() {
		return movieCollection;
	}

}
