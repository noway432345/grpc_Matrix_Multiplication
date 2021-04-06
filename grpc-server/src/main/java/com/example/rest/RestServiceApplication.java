package com.example.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestServiceApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(RestServiceApplication.class, args);
	}

}
