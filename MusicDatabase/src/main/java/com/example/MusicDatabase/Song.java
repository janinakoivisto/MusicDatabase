package com.example.MusicDatabase;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity 
public class Song {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	private String songTitle;
	private String artistName;
	private int releaseYear;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name= "genreId")
	private Genre genre;
	
	

	
	public Song(Long id, String songTitle, String artistName, int releaseYear) {
		super();
		this.id = id;
		this.songTitle = songTitle;
		this.artistName = artistName;
		this.releaseYear = releaseYear;
	}
	
	
	
	public Song(String songTitle, String artistName, int releaseYear, Genre genre) {
		super();
	}
	
	public Song(Long id, String songTitle, String artistName, int releaseYear, Genre genre) {
		super();
	}
	
// getters and setters
	

	public Song() {
		// TODO Auto-generated constructor stub
	}



	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getSongTitle() {
		return songTitle;
	}
	
	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}
	
	public String getArtistName() {
		return artistName;
	}
	
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	
	public int getReleaseYear() {
		return releaseYear;
	}
	
	public Genre getGenre() {
		return genre;
	}



	public void setGenre(Genre genre) {
		this.genre = genre;
	}



	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	
	
	// toString
	
		@Override
	public String toString() {
			if (this.genre != null) {
		return "Song [id=" + id + ", songTitle=" + songTitle + ", artistName=" + artistName + ", releaseYear="
				+ releaseYear + ", genre=" + this.getGenre() + "]";
			} else {
				return "Song [id=" + id + ", songTitle=" + songTitle + ", artistName=" + artistName + ", releaseYear="
						+ releaseYear + "]";
			}
	}
	
	
	
}