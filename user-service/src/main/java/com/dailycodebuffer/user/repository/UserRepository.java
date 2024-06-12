package com.dailycodebuffer.user.repository;

import org.springframework.stereotype.Repository;

import com.dailycodebuffer.user.entity.TUser;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface UserRepository extends JpaRepository<TUser, Long> {

	TUser findByUserId(Long userId);

}
