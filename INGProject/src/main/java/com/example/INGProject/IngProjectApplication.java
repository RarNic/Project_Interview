package com.example.INGProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.exemple.INGProject")
public class IngProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(IngProjectApplication.class, args);
	}

}
