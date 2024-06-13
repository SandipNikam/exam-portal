package com.springexamportal.service1.impl;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springexamportal.model.exam.Category;
import com.springexamportal.model.exam.Quiz;
import com.springexamportal.repository.QuizRepo;
import com.springexamportal.service1.QuizService;
@Service
public class QuizServiceImpl implements QuizService{

	@Autowired
	private QuizRepo qr;
	
	@Override
	public Quiz addQuiz(Quiz q) {
		
		return this.qr.save(q);
	}

	@Override
	public Quiz updateQuiz(Quiz q) {
		
		return this.qr.save(q);
	}

//	@Override
//	public Set<Quiz> getQuizes() {
//	
//		return (Set<Quiz>) this.qr.findAll();
//	}

	@Override
	public Set<Quiz> getQuizes() {
	    List<Quiz> categoryList = (List<Quiz>) this.qr.findAll(); 
	    return new LinkedHashSet<>(categoryList);
	}
	
	@Override
	public Quiz getQuiz(Long quizId) {
		
		return this.qr.findById(quizId).get();
	}

	@Override
	public void deleteQuiz(Long id) {
	
	this.qr.deleteById(id);
		
	}
//find quiz by category
	@Override
	public List<Quiz> getQuizesOfCategory(Category category) {
		return this.qr.findByCategory(category);
		
	}
//get active quizes

	@Override
	public List<Quiz> getActiveQuizes() {
		
		return this.qr.findByActive(true);
	}

	@Override
	public List<Quiz> getActiveQuizesOfCategory(Category c) {
		
		return this.qr.findByCategoryAndActive(c, true);
	}
	
}
