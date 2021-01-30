package com.abans.abansweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AbansWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbansWebApplication.class, args);
	}

}
