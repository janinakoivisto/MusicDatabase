package com.example.MusicDatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig  {
	@Autowired
	private UserDetailServiceImpl userDetailsService;
	
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests().requestMatchers("/css/**").permitAll()
		.requestMatchers("/delete/**").hasAuthority("ADMIN") // vain adminilla mahdollisuus poistaa kappaleita
		.requestMatchers("/edit/**", "/addsong").hasAnyAuthority("USER", "ADMIN") // käyttäjä ja admin voivat molemmat lisätä ja muokata kappaleita
		.requestMatchers("/signup", "/saveuser").permitAll()
		.and()
		.authorizeHttpRequests().anyRequest().authenticated()
		.and()
		.headers().frameOptions().disable() 		
		.and()
		.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/songlist", true)
		.permitAll()
		.and()
		.httpBasic();
				
		return http.build();
	}


	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}}