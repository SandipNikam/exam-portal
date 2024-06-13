package com.springexamportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springexamportal.model.exam.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {

}
