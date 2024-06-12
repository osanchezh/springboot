package com.example.deparment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.deparment.entity.Department;
import com.example.deparment.service.DepartmentService;

@RestController
public class DepartmentController {
	private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	@Autowired
	private DepartmentService departmentService;
	
	public DepartmentService getDepartmentService() {
		return departmentService;
	}
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	@PostMapping("/departments")
	public Department saveDeparment(@RequestBody Department deparment) {
		LOGGER.info("inside saveDepartment - DeparmentController");
		return this.departmentService.saveDepartment(deparment);
	}
	@GetMapping("/departments/{id}")
	public Department findDeparmentById(@PathVariable("id") Long deparmentid) {
		LOGGER.info("inside findDeparmentById - DeparmentController");
		return this.departmentService.findDeparmentById(deparmentid);
	}
	
	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
}
