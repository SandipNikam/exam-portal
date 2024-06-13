package com.springexamportal.service1;

import java.util.Set;

import com.springexamportal.model.exam.Question;
import com.springexamportal.model.exam.Quiz;

public interface QuestionService {

	public Question addQuestion(Question q);
	public Question updateQuestion(Question q);
	public Set<Question> getQuestions();
	public Question getQuestion(Long id);
	public Set<Question> getQuestionsOfQuiz(Quiz q);
	public void deleteQn(Long id);
	public Question get(Long questionId);
}
