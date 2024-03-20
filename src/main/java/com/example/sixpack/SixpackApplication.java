package com.example.sixpack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SixpackApplication {

	public static void main(String[] args) {
		SpringApplication.run(SixpackApplication.class, args);
	}

}
