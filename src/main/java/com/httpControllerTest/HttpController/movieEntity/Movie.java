package com.httpControllerTest.HttpController.movieEntity;

public class Movie {

	private int id;
	private String name;
	private String language;
	private String type;

	public Movie(String name, String language, String type) {
		super();
		this.name = name;
		this.language = language;
		this.type = type;
	}

	public Movie(int id, String name, String language, String type) {
		super();
		this.id = id;
		this.name = name;
		this.language = language;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
