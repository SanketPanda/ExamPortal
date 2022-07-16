package com.ddce.examportal.service;

import java.util.Set;

import com.ddce.examportal.DTO.QuestionDTO;
import com.ddce.examportal.entity.exam.Question;
import com.ddce.examportal.entity.exam.Quiz;

public interface QuestionService {
	public Question addQuestion(QuestionDTO quizDTO);

	public Question updateQuestion(Question question);

	public Set<Question> getQuestions();

	public Question getQuestion(Long id);

	public void deleteQuestion(Long id);
	
	public Set<Question> getQuestionsOfQuiz(Long quizId);
}
