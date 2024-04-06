package com.schoolmanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.repositories.CustomDao;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class AppConfig {

//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails userDetails = User.builder().username("Tushar").password(passwordEncoder().encode("Tushar")).roles("ADMIN").build();
//		return new InMemoryUserDetailsManager(userDetails);
//	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	 @Bean
	   public JdbcTemplate jdbcTemplate(HikariDataSource hikariDataSource){
	       return new JdbcTemplate(hikariDataSource);
	   }
	 
	 @Bean
	 public CustomDao customDao()
	 {
		 return new CustomDao();
	 }
}
