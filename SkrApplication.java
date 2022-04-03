package com.SKR;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.Controller")
@EntityScan("com.Model")
@EnableJpaRepositories("com.Repository")
public class SkrApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkrApplication.class, args);
	}

}
