package com.example.deparment;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.deparment.controller.DepartmentController;
import com.example.deparment.service.DepartmentService;

@SpringBootApplication
//@ComponentScan(basePackages = "com.example")
//@EnableAutoConfiguration
//@Configuration
//@EnableJpaRepositories("com.example.deparment.repository")
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			//String[] beanNames = ctx.getBeanDefinitionNames();
			//Arrays.sort(beanNames);
			//for (String beanName : beanNames) {
			//	System.out.println(beanName);
			//}

		};
	}
}
