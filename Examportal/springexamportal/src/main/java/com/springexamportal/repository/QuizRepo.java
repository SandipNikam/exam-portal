package com.springexamportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springexamportal.model.exam.Category;
import com.springexamportal.model.exam.Quiz;

public interface QuizRepo extends JpaRepository<Quiz, Long>{
	public List<Quiz> findByCategory(Category category);
	
	public List<Quiz> findByActive(Boolean b);
	
	public List<Quiz> findByCategoryAndActive(Category c,Boolean b);
	
	
}
