package com.example.deparment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.deparment.entity.Department;

@Repository
public interface DeparmentRepository extends JpaRepository<Department, Long> {

	Department findByDepartmentId(Long deparmentid);

}
