package com.springexamportal.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springexamportal.model.exam.Category;
import com.springexamportal.model.exam.Quiz;
import com.springexamportal.service1.QuizService;


@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {

	@Autowired
	private QuizService qs;
	
	
	//add quiz
	@PostMapping("/")
	public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz){
		return ResponseEntity.ok(this.qs.addQuiz(quiz));
	}
	
	//update quiz
		@PutMapping("/")
		public ResponseEntity<Quiz> updateQuizData(@RequestBody Quiz quiz){
			return ResponseEntity.ok(this.qs.updateQuiz(quiz));
		}
		

		//get quiz
		@GetMapping("/{id}")
		public ResponseEntity<Quiz> getQuizData(@PathVariable("id")Long id) {
			return ResponseEntity.ok(this.qs.getQuiz(id));
		}
		
		//get all quizes
		@GetMapping("/")
		public ResponseEntity<Set<Quiz>> getAllQuizes(){
		return ResponseEntity.ok(this.qs.getQuizes());
		}
		//delete quiz
		@DeleteMapping("/{qId}")
		public void deleteQuizById(@PathVariable("qId")Long id) {
			this.qs.deleteQuiz(id);
		
	}
		
		//get quizes of particular categories
		@GetMapping("/category/{cid}")
		public List<Quiz> getQuizesOfCategory(@PathVariable("cid") Long cid){
			
			Category category = new Category();
			category.setId(cid);
			return this.qs.getQuizesOfCategory(category);
		}
		
		//get active quizes
		@GetMapping("/active")
		public List<Quiz> getActive(){
			return this.qs.getActiveQuizes();
		}
		
		//get active quizes of category
				@GetMapping("category/active/{cid}")
				public List<Quiz> getActiveQuizesCategory(@PathVariable("cid")Long cid){
					Category category = new Category();
					category.setId(cid);
					return this.qs.getActiveQuizesOfCategory(category);
				}
}
