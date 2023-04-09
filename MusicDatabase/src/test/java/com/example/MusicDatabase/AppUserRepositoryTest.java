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
public class AppUserRepositoryTest {

			@Autowired
			private AppUserRepository repository;
	 
			@Test
			public void findByUsernameReturnAppUser() {
					AppUser appUsers = repository.findByUsername("user");
					
					assertThat(appUsers.getUsername()).isEqualTo("user");
			}
			
			@Test
				public void createNewAppUser() {
				AppUser appUser = new AppUser("user2", "$2a$10$gBPlD34jIkSTTMYVHON/NeAiI.MG.1u8QmPcvNVXJbYvwz10C0SEK", "USER" );
				repository.save(appUser);
				assertThat(appUser.getId()).isNotNull();
			}
		}
	

