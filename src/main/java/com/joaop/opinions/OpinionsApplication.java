package com.joaop.opinions;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OpinionsApplication {

	public static void main(String[] args) {
		checkEnv();
		SpringApplication.run(OpinionsApplication.class,
				args);

	}

	@PostConstruct
	public static void checkEnv() {
		System.out.println("DB_URL do sistema: " + System.getenv("DB_URL"));

	}

}
