package com.example.deparment.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
	  private @Id 
	  @GeneratedValue(strategy=GenerationType.AUTO) 
	  Long idEmployee;
	  private String name;
	  private String role;

	  public Employee() {}

	  public Employee(String name, String role) {

	    this.name = name;
	    this.role = role;
	  }



	  public String getName() {
	    return this.name;
	  }

	  public String getRole() {
	    return this.role;
	  }



	  public void setName(String name) {
	    this.name = name;
	  }

	  public void setRole(String role) {
	    this.role = role;
	  }

	public Long getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(Long idEmployee) {
		this.idEmployee = idEmployee;
	}




	  
	  
}
