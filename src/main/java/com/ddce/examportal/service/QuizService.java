package com.ddce.examportal.service;

import java.util.Set;

import com.ddce.examportal.DTO.QuizDTO;
import com.ddce.examportal.entity.exam.Quiz;

public interface QuizService {
	public Quiz addQuiz(QuizDTO quizDTO);

	public Quiz updateQuiz(QuizDTO quizDTO);

	public Set<Quiz> getQuizzes();

	public Quiz getQuiz(Long id);

	public void deleteQuiz(Long id);
}
