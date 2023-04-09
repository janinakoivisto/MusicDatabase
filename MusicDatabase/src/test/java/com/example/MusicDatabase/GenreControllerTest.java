package com.example.MusicDatabase;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class GenreControllerTest {

	@Autowired
	private GenreController controller;
	
	
	@Test
	void contextLoads()throws Exception {
		assertThat(controller).isNotNull();
	
}}
