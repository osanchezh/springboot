package com.example.deparment.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.deparment.assambler.EmployeeModelAssembler;
import com.example.deparment.entity.Employee;
import com.example.deparment.exception.EmployeeNotFoundException;
import com.example.deparment.repository.EmployeeRepository;



@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeModelAssembler employeeModelAssembler;
/*
	@GetMapping("/employees")
	public List<Employee> all() {
	    return employeeRepository.findAll();
	  }
*/
	


	@GetMapping("/employees")
	public CollectionModel<EntityModel<Employee>> all() {
/*
	  List<EntityModel<Employee>> employees = employeeRepository.findAll().stream()
	      .map(employee -> EntityModel.of(employee,
	    		  WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmployeeController.class).one(employee.getId())).withSelfRel(),
	    		  WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmployeeController.class).all()).withRel("employees")))
	      .collect(Collectors.toList());
*/


	  List<EntityModel<Employee>> employees = employeeRepository.findAll().stream() //
		      .map(employeeModelAssembler::toModel) //
		      .collect(Collectors.toList());

		  return CollectionModel.of(employees, WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmployeeController.class).all()).withSelfRel());
		  
	  	}
	
	  @PostMapping("/employees")
	  public Employee newEmployee(@RequestBody Employee newEmployee) {
	    return employeeRepository.save(newEmployee);
	  }

	  // Single item
	  /*
	  @GetMapping("/employees/{id}")
	  public Employee one(@PathVariable Long id) {
	    
	    return employeeRepository.findById(id)
	      .orElseThrow(() -> new EmployeeNotFoundException(id));
	  }
*/
	  @GetMapping("/employees/{id}")
	  public EntityModel<Employee> one(@PathVariable Long id) {

	    Employee employee = employeeRepository.findById(id) //
	        .orElseThrow(() -> new EmployeeNotFoundException(id));

	    //return EntityModel.of(employee, //
	    //		WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmployeeController.class).one(id)).withSelfRel(),
	    //		WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmployeeController.class).all()).withRel("employees"));
	    
	    return employeeModelAssembler.toModel(employee);
	  }
	  
	  @PutMapping("/employees/{id}")
	  public Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
	    
	    return employeeRepository.findById(id)
	      .map(employee -> {
	        employee.setName(newEmployee.getName());
	        employee.setRole(newEmployee.getRole());
	        return employeeRepository.save(employee);
	      })
	      .orElseGet(() -> {
	        newEmployee.setIdEmployee(id);
	        return employeeRepository.save(newEmployee);
	      });
	  }

	  @DeleteMapping("/employees/{id}")
	  public void deleteEmployee(@PathVariable Long id) {
		  employeeRepository.deleteById(id);
	  }
	  
	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}

	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public EmployeeModelAssembler getEmployeeModelAssembler() {
		return employeeModelAssembler;
	}

	public void setEmployeeModelAssembler(EmployeeModelAssembler employeeModelAssembler) {
		this.employeeModelAssembler = employeeModelAssembler;
	}
}
