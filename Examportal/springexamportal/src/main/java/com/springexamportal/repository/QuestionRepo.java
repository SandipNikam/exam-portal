package com.springexamportal.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springexamportal.model.exam.Question;
import com.springexamportal.model.exam.Quiz;

public interface QuestionRepo extends JpaRepository<Question, Long>{

	Set<Question> findByQuiz(Quiz q);

}
