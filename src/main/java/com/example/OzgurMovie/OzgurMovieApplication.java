package com.example.OzgurMovie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class OzgurMovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(OzgurMovieApplication.class, args);
	}

}
