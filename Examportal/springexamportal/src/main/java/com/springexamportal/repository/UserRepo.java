package com.springexamportal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springexamportal.model.User;

public interface UserRepo extends JpaRepository<User, Long>{

	//find by username
	public User findByUsername(String username);
	
	//get by id
	public User getUserById(Long id);
}
