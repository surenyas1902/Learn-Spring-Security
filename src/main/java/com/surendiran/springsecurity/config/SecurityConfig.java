package com.surendiran.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		UserBuilder users = User.withDefaultPasswordEncoder();

		auth.inMemoryAuthentication().withUser(users.username("surendiran").password("test123").roles("EMPLOYEE"))
				.withUser(users.username("yaswanth").password("test123").roles("MANAGER"))
				.withUser(users.username("somnath").password("test123").roles("ADMIN"));

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests() // Enabling Security
				.antMatchers("/resources/**").permitAll()
				.anyRequest() // For All Requests
				.authenticated() // Check For Authentication
				.and() // And
				.formLogin() // Customer Login type
				.loginPage("/formlogin") // URL for Login page
				.loginProcessingUrl("/authenticate") // After Submit button, where to validate the request
				.permitAll() // Enable Login Page available for everyone
				.and() // And
				.logout() // Logout functionality enabled
				.permitAll(); // Enable Logout available for everyone
	}

}
