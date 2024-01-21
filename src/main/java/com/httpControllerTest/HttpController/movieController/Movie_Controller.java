package com.httpControllerTest.HttpController.movieController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Movie_Controller {

	@GetMapping("")
	public String welcome() {
		return "Welcome to movie cinema! => type in URL http://localhost:8080/movies";
	}
	
	@GetMapping("/movies")
	public String sentMovieInfo() {
		return String.format("%d%s\t%d%s\t%d%s\t%s", 1,". Drama", 2, ". Romance", 3, ". Adventure", " => type in URL http://localhost:8080/movies/drama");
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
