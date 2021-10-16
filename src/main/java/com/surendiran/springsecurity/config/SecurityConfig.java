package com.surendiran.springsecurity.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
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

	// add a reference to our security data source
	@Autowired
	private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// use jdbc authentication
		
		auth.jdbcAuthentication().dataSource(securityDataSource);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests() // Enabling Security
				.antMatchers("/resources/**").permitAll()
					/*
					.anyRequest() // For All Requests
					.authenticated() // Check For Authentication
					*/
					.antMatchers("/").hasRole("EMPLOYEE") // This will run the above anyRequest and authenticated method and it will check for Roles specified
					.antMatchers("/leaders/**").hasAnyRole("MANAGER", "ADMIN")
					.antMatchers("/systems/**").hasRole("ADMIN")
				.and() // And
				.formLogin() // Customer Login type
					.loginPage("/formlogin") // URL for Login page
					.loginProcessingUrl("/authenticate") // After Submit button, where to validate the request and Spring will automatically create the endpoint
					.permitAll() // Enable Login Page available for everyone
				.and() // And
				.logout() // Logout functionality enabled
				.permitAll() // Enable Logout available for everyone
				.and()
				.exceptionHandling()
					.accessDeniedPage("/404");
	}

}
