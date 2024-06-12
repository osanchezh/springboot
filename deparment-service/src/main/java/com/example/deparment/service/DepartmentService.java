package com.example.deparment.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.deparment.entity.Department;
import com.example.deparment.repository.DeparmentRepository;

@Service
public class DepartmentService {
	
	private final Logger LOGGER = LoggerFactory.getLogger(DepartmentService.class);
	@Autowired
  private DeparmentRepository departmentRepository;

	public DeparmentRepository getDepartmentRepository() {
		return departmentRepository;
	}

	public void setDepartmentRepository(DeparmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}

	public Department saveDepartment(Department deparment) {
		LOGGER.info("inside saveDepartment - DepartmentService");
		return departmentRepository.save(deparment);
	}

	public Department findDeparmentById(Long deparmentid) {
		LOGGER.info("inside findDeparmentById - DepartmentService");
		return departmentRepository.findByDepartmentId(deparmentid);
	}


}
