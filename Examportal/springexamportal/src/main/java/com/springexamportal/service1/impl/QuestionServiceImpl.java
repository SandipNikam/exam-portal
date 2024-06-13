package com.springexamportal.service1.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springexamportal.model.exam.Question;
import com.springexamportal.model.exam.Quiz;
import com.springexamportal.repository.QuestionRepo;
import com.springexamportal.service1.QuestionService;
@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired 
	private QuestionRepo qr;
	
	@Override
	public Question addQuestion(Question q) {
	 
		return this.qr.save(q);
	}

	@Override
	public Question updateQuestion(Question q) {
		 
		return this.qr.save(q);
	}

	@Override
	public Set<Question> getQuestions() {
		 
		return new HashSet<>(this.qr.findAll());
	}

	@Override
	public Question getQuestion(Long id) {
		 
		return this.qr.findById(id).get();
	}

	@Override
	public Set<Question> getQuestionsOfQuiz(Quiz q) {
		 
		return this.qr.findByQuiz(q);
	}

	@Override
	public void deleteQn(Long id) {
		Question question = new Question();
		question.setQuesId(id);
		this.qr.delete(question);
		
	}

	@Override
	public Question get(Long questionId) {
		
		return this.qr.getOne(questionId);
	}

}
