package com.ddce.examportal.controller;

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

import com.ddce.examportal.DTO.QuizDTO;
import com.ddce.examportal.entity.exam.Quiz;
import com.ddce.examportal.service.QuizService;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {

	@Autowired
	QuizService quizService;
	
	@PostMapping("/add")
	private ResponseEntity<Quiz> addQuiz(@RequestBody QuizDTO quizDTO){
		return ResponseEntity.ok(quizService.addQuiz(quizDTO));
	}
	
	@PutMapping("/update")
	private ResponseEntity<Quiz> updateQuiz(@RequestBody QuizDTO quizDTO){
		return ResponseEntity.ok(quizService.updateQuiz(quizDTO));
	}
	
	@GetMapping("/")
	private ResponseEntity<?> getQuizzes(){
		return ResponseEntity.ok(quizService.getQuizzes());
	}
	
	@GetMapping("/{quizId}")
	private ResponseEntity<Quiz> getQuizById(@PathVariable("quizId") Long quizId){
		return ResponseEntity.ok(quizService.getQuiz(quizId));
	}
	
	@DeleteMapping("/{quizId}")
	private void deleteQuizById(@PathVariable("quizId") Long quizId) {
		quizService.deleteQuiz(quizId);
	}
}
