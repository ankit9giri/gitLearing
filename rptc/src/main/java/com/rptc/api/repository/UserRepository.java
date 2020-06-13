package com.rptc.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rptc.api.entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);

}

