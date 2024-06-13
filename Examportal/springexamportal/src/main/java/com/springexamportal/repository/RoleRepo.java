package com.springexamportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springexamportal.model.Role;

public interface RoleRepo extends JpaRepository<Role, Long>{

}
