package com.ddce.examportal.service.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddce.examportal.DTO.QuizDTO;
import com.ddce.examportal.entity.exam.Quiz;
import com.ddce.examportal.repositary.QuizRepositary;
import com.ddce.examportal.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	QuizRepositary quizRepositary;
	
	@Override
	public Quiz addQuiz(QuizDTO quizDTO) {
		Quiz quiz = quizDTO_to_Quiz(quizDTO);
		return quizRepositary.save(quiz);
	}

	@Override
	public Quiz updateQuiz(QuizDTO quizDTO) {
		Quiz quiz = quizDTO_to_Quiz(quizDTO);
		return quizRepositary.save(quiz);
	}

	@Override
	public Set<Quiz> getQuizzes() {
		return new LinkedHashSet<>(quizRepositary.findAll());
	}

	@Override
	public Quiz getQuiz(Long id) {
		return quizRepositary.findById(id).get();
	}

	@Override
	public void deleteQuiz(Long id) {
		quizRepositary.deleteById(id);
	}
	
	public Quiz quizDTO_to_Quiz(QuizDTO quizDTO) {
		Quiz quiz = new Quiz();
		quiz.setDescription(quizDTO.getDescription());
		quiz.setTitle(quizDTO.getTitle());
		quiz.setActive(quizDTO.isActive());
		quiz.setMaxMark(quizDTO.getMaxMark());
		quiz.setNoOfQuestion(quizDTO.getNoOfQuestion());
		
		return quiz;
	}

}
