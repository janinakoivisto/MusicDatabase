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
	public class GenreRepositoryTest {
	
		@Autowired
		private GenreRepository repository;
 
		@Test
		public void findByNameShouldReturnGenre() {
				List<Genre> genres = repository.findByName("Electronic");
				assertThat(genres).hasSize(1);
				assertThat(genres.get(0).getName()).isEqualTo("Electronic");
		}
		
		@Test
			public void createNewGenre() {
			Genre genre = new Genre("Metal");
			repository.save(genre);
			assertThat(genre.getId()).isNotNull();
		}
	}