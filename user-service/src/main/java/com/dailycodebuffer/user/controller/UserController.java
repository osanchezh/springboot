package com.dailycodebuffer.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodebuffer.user.entity.TUser;
import com.dailycodebuffer.user.service.UserService;
import com.dailycodebuffer.user.vo.ResponseTemplateVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
public class UserController {
	private final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
  @Autowired
  private UserService userService;
  
  @PostMapping("/users")
  public TUser saveUser(@RequestBody TUser user) {
	  if(user!=null)
	  LOGGER.info("user -> "+user.toString());
	  return userService.saveUser(user);
  }
  
  @GetMapping("/users/{id}")
  public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
	  if(userId!=null)
	  LOGGER.info("user -> "+userId);
	  return userService.getUserWithDepartment(userId);
	  
  }
}
