package com.example.deparment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
  private Long departmentId;
	private String departmentName;
	  private String deparmentAddress;
	  private String deparmentCode;
	  
  public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDeparmentAddress() {
		return deparmentAddress;
	}
	public void setDeparmentAddress(String deparmentAddress) {
		this.deparmentAddress = deparmentAddress;
	}
	public String getDeparmentCode() {
		return deparmentCode;
	}
	public void setDeparmentCode(String deparmentCode) {
		this.deparmentCode = deparmentCode;
	}

}
