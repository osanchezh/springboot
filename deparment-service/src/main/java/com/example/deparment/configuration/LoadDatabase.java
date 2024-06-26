package com.example.deparment.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.deparment.entity.Employee;
import com.example.deparment.repository.EmployeeRepository;
import com.example.deparment.service.DepartmentService;

@Configuration
public class LoadDatabase {
	private final Logger LOGGER = LoggerFactory.getLogger(LoadDatabase.class);
	  @Bean
	  CommandLineRunner initDatabase1(EmployeeRepository repository) {

	    return args -> {
	    	LOGGER.info("Preloading " + repository.save(new Employee("Bilbo Baggins", "burglar")));
	    	//LOGGER.info("Preloading " + repository.save(new Employee("Frodo Baggins", "thief")));
	    };
	  }
}
