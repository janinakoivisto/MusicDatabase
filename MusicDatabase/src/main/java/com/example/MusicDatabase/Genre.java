package com.example.MusicDatabase;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Genre {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long genreId;
	
	private String genreName;

	public Long getId() {
		return genreId;
	}

	public void setId(Long genreId) {
		this.genreId = genreId;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	@Override
	public String toString() {
		return "Genre [genreId=" + genreId + ", genreName=" + genreName + "]";
	}
	

	
}
