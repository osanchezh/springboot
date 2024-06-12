package com.dailycodebuffer.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dailycodebuffer.user.entity.TUser;
import com.dailycodebuffer.user.repository.UserRepository;
import com.dailycodebuffer.user.vo.Department;
import com.dailycodebuffer.user.vo.ResponseTemplateVO;

@Service
public class UserService {
	private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
	private UserRepository userRepository;
    @Autowired
	private RestTemplate restTemplate;
	
	
	public TUser saveUser(TUser user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}


	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		ResponseTemplateVO vo= new ResponseTemplateVO();
		TUser user = userRepository.findByUserId(userId);
		LOGGER.debug("user.getUserId()="+user.getUserId());
		Department department = restTemplate.getForObject("http://DEPARMENT-SERVICE/departments/"+user.getUserId(), Department.class);
		vo.setUser(user);
		vo.setDepartment(department);
		return vo;
	}




}
