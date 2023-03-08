package com.example.springsecuritylearn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MySecurityConfig 
{	
	@Bean
	public InMemoryUserDetailsManager userDetailsService()
	{
		UserDetails user=User.withUsername("abc")
				.password("abc").roles("USER")
				.build();
//		UserDetails user1=User.withUsername("xyz")
//				.password("xyz").roles("USER")
//				.build();
		return new InMemoryUserDetailsManager(user);
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		http.csrf().disable();	
		http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
		return http.build();
	}
	
	@Bean
	public NoOpPasswordEncoder passwordEncoder()
	{
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
}

