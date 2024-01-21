package com.httpControllerTest.HttpController.movieController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.httpControllerTest.HttpController.movieEntity.Movie;
import com.httpControllerTest.HttpController.serviceImpl.Movie_Service_Impl;

@RestController
public class Movie_Controller {
	
	@Autowired
	Movie_Service_Impl movieService;

	@GetMapping("")
	public String welcome() {
		return "Welcome to movie cinema! => type in URL http://localhost:8080/movies";
	}
	
	@GetMapping("/movies")
	public String sentMovieInfo() {
		return String.format("%d%s\t%d%s\t%d%s\t%d%s\t%s", 1,". All", 2, ". Drama", 3, ". Romance", 4, ". Adventure", " => type in URL http://localhost:8080/movies/drama");
	}
	
	@GetMapping("/movies/all")
	public ResponseEntity<List<Movie>> getAll() {
		List<Movie> movies = movieService.getAllMovies();
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}
	
	@GetMapping("/movies/drama")
	public String sentDrame() {
		return "Welcome to Drama Movie Collection";
	}
	
	@GetMapping("/movies/romance")
	public String sentRomance() {
		return "Welcome to Romance Movie Collection";
	}
	
	@GetMapping("/movies/adventure")
	public String sentAdventure() {
		return "Welcome to Adventure Movie Collection";
	}
	
	
}
