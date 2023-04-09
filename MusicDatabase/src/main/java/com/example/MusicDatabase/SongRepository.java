package com.example.MusicDatabase;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song, Long>{
	List<Song> findBySongTitle(String songTitle);
	
	List<Song> findByArtistName(String artistName);
}