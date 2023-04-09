package com.example.MusicDatabase;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
	public class SongRepositoryTest {
	
		@Autowired
		private SongRepository repository;
 
		@Test
		public void findBySongTitleShouldReturnSong() {
				List<Song> songs = repository.findBySongTitle("Ache");
				assertThat(songs).hasSize(1);
				assertThat(songs.get(0).getArtistName()).isEqualTo("FKA twigs");
		}
		
		@Test
			public void createNewSong() {
			Song song = new Song("Anticure", "Whitechapel", 2021, new Genre("Metal"));
			repository.save(song);
			assertThat(song.getId()).isNotNull();
		}
	}