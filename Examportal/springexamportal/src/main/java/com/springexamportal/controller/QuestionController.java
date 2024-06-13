package com.springexamportal.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
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
import com.springexamportal.model.exam.Question;
import com.springexamportal.model.exam.Quiz;
import com.springexamportal.service1.QuestionService;
import com.springexamportal.service1.QuizService;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {

	@Autowired
	private QuestionService qs;
	
	@Autowired
	private QuizService service;
	
	//add question
	@PostMapping("/")
	public ResponseEntity<Question> addQns(@RequestBody Question q){
		return ResponseEntity.ok(this.qs.addQuestion(q));
	}
	
	//update qn
	
	@PutMapping("/")
	public ResponseEntity<Question> updateQns(@RequestBody Question q){
		return ResponseEntity.ok(this.qs.updateQuestion(q));
	}
	
	//get all qn of any quiz
	@GetMapping("/quiz/{quizId}")
	public ResponseEntity<?> getQnsOfQuiz(@PathVariable("quizId") Long id){
//		Quiz q=new Quiz();
//		q.setqId(id);
//		
//		Set<Question> questionsOfQuiz = this.qs.getQuestionsOfQuiz(q);
//		return ResponseEntity.ok(questionsOfQuiz);
		
		Quiz quiz = this.service.getQuiz(id);
		Set<Question> questions = quiz.getQuestions();
		List<Question> list=new ArrayList(questions);
		if(list.size()>Integer.parseInt(quiz.getNumberOfQuetions())) {
			list=list.subList(0,Integer.parseInt((quiz.getNumberOfQuetions())));
			
		}
		list.forEach((q)->{
			q.setAnswer("");
		});
		Collections.shuffle(list);
		return ResponseEntity.ok(list);
	}
	
	//get all qn of any quiz
	@GetMapping("/quiz/all/{quizId}")
	public ResponseEntity<?> getQnsOfQuizAdmin(@PathVariable("quizId") Long id){
		Quiz q=new Quiz();
		q.setqId(id);
		
		Set<Question> questionsOfQuiz = this.qs.getQuestionsOfQuiz(q);
	
		return ResponseEntity.ok(questionsOfQuiz);
		
		
	
	}
	
	
	
	
	//get question
	
		@GetMapping("/{id}")
		public ResponseEntity<Question> getCategory(@PathVariable("id")Long id) {
			return ResponseEntity.ok(this.qs.getQuestion(id));
		}
		

		//delete question
		@DeleteMapping("/{id}")
		public void deleteQuestion(@PathVariable("id")Long id) {
			this.qs.deleteQn(id);
		}
		
		//evaluate quiz
		
		@PostMapping("/eval-quiz")
		public ResponseEntity<?> evalQuiz(@RequestBody List<Question> questions){
			System.out.println(questions);
			Double marksGot=0d;
			Integer  correctAnswers=0;
			Integer  attempted=0;
			for(Question q:questions){
				//single question
			Question question = this.qs.get(q.getQuesId());
			
			if(question.getAnswer().equals(q.getGivenAnswer())) {
				//correct
				correctAnswers++;
				
				double marksSingle= Double.parseDouble( questions.get(0).getQuiz().getMaxMarks())/questions.size();
				marksGot+=marksSingle;
			}
			if(q.getGivenAnswer()!=null) {
				attempted++;
			}
			}
Map<String,Object> map=Map.of("marksGot",marksGot,"correctAnswers",correctAnswers,"attempted",attempted);
			
			return ResponseEntity.ok(map);
		}
		
		
		
}
