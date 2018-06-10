package com.lc.springbootlession8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.lc.springbootlession8")
public class SpringBootLession8Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLession8Application.class, args);
	}
}
