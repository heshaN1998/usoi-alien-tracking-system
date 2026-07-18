package com.soft_universe.tranneer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class AlienNeutrilizerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlienNeutrilizerApplication.class, args);
	}

}
