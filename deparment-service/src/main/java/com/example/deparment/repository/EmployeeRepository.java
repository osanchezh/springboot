package com.example.deparment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.deparment.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
