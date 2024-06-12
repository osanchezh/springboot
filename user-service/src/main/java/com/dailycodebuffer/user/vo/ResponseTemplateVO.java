package com.dailycodebuffer.user.vo;

import com.dailycodebuffer.user.entity.TUser;


public class ResponseTemplateVO {
 public TUser getUser() {
		return user;
	}
	public void setUser(TUser user) {
		this.user = user;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
private TUser user;
 private Department department;
}
