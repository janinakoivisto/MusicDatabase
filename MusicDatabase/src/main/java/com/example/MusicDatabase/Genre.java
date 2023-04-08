package com.example.MusicDatabase;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity

public class Genre {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long genreId;
	
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "genre")
	private List<Song> songs;
	
	public Genre(String name) {
		super();
		this.name = name;
	}

	
	public Genre() {
		super();
	}
	
	public Long getId() {
		return genreId;
	}

	public void setId(Long genreId) {
		this.genreId = genreId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Song> getSongs() {
		return songs;
	}

	public void setStudents(List<Song> songs) {
		this.songs = songs;
	}

	@Override
	public String toString() {
		return "Genre [genreId=" + genreId + ", name=" + name + "]";
	}
	

	
}
