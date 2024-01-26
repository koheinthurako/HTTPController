package com.httpControllerTest.HttpController.movieController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.httpControllerTest.HttpController.movieEntity.Movie;
import com.httpControllerTest.HttpController.serviceImpl.Movie_Service_Impl;

@RestController
public class Movie_Controller {
	
	@Autowired
	Movie_Service_Impl movieService;
	
//	Server to => Client

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
	
	@GetMapping("/movies/{id}")
	public ResponseEntity<Movie> getById(@PathVariable int id) {
		return new ResponseEntity<Movie>(movieService.getById(id), HttpStatus.OK);
	}
	
	
	
//	Client to => Server
	
	@PostMapping("/movies/msgAll/{all}")
	public void all(@PathVariable("all") String msg) {
		System.out.println("Received Message : " + "show " + msg + " movies");
	}
	
	@PostMapping("/movies/msgDra/{drama}")
	public void drama(@PathVariable("drama") String msg) {
		System.out.println("Received Message : " + "show " + msg + " movies");
	}
	
	@PostMapping("/movies/msgRo/{romance}")
	public void romance(@PathVariable("romance") String msg) {
		System.out.println("Received Message : " + "show " + msg + " movies");
	}
//	
	@PostMapping("/movies/msgAdv/{adventure}")
	public void adventure(@PathVariable("adventure") String msg) {
		System.out.println("Received Message : " + "show " + msg + " movies");
	}
	
	@PostMapping("/movies/add")
	public ResponseEntity<Movie> addNew(@RequestBody Movie mov) {
		return new ResponseEntity<Movie>(movieService.addNewMovie(mov), HttpStatus.CREATED);
	}
	
	@PostMapping("/movies/{name}")
	public ResponseEntity<Movie> getByName(@PathVariable String name) {
		return new ResponseEntity<Movie>(movieService.getByName(name), HttpStatus.OK);
	}
	
	
	// Use @PutMapping to update data
	@PutMapping("/movies/update/{id}")
	public ResponseEntity<Movie> updateInfo(@PathVariable int id, @RequestBody Movie movie) {
		return new ResponseEntity<Movie>(movieService.updateInfo(id, movie), HttpStatus.OK);
	}
	
	
	@DeleteMapping("movies/delete/{id}")
	public String deleteMovie(@PathVariable int id) {
		return movieService.deleteMovie(id);
	}
	
	
	
	
	
}
