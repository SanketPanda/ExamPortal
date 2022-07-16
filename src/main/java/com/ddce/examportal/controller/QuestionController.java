package com.ddce.examportal.controller;

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

import com.ddce.examportal.DTO.QuestionDTO;
import com.ddce.examportal.entity.exam.Question;
import com.ddce.examportal.service.QuestionService;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@PostMapping("/add")
	private ResponseEntity<Question> addQuestion(@RequestBody QuestionDTO questionDTO){
		return ResponseEntity.ok(this.questionService.addQuestion(questionDTO));
	}
	
	@PutMapping("/update")
	private ResponseEntity<Question> updateQuestion(@RequestBody Question question){
		return ResponseEntity.ok(this.questionService.updateQuestion(question));
	}
	
	@GetMapping("/quiz/{quizId}")
	private ResponseEntity<?> getQuestionOfQuiz(@PathVariable("quizId") Long quizId){
		Set<Question> questionsOfQuiz = this.questionService.getQuestionsOfQuiz(quizId);
		return ResponseEntity.ok(questionsOfQuiz);
	}
	
	@GetMapping("/{questionId}")
	private ResponseEntity<Question> getQuestionById(@PathVariable("questionId") Long questionId){
		return ResponseEntity.ok(this.questionService.getQuestion(questionId));
	}
	
	@DeleteMapping("/{questionId}")
	private void deleteQuestionById(@PathVariable("questionId") Long questionId){
		this.questionService.deleteQuestion(questionId);
	}
}
