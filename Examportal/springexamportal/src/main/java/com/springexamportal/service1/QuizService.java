package com.springexamportal.service1;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;

import com.springexamportal.model.exam.Category;
import com.springexamportal.model.exam.Quiz;

public interface QuizService {

	public Quiz addQuiz(Quiz q);
	public Quiz updateQuiz(Quiz q);
	public Set<Quiz> getQuizes();
	public Quiz getQuiz(Long quizId);
	public void deleteQuiz(Long id);
	public List<Quiz> getQuizesOfCategory(Category category);
	public List<Quiz>  getActiveQuizes();
	public List<Quiz>  getActiveQuizesOfCategory(Category c);
	
}
