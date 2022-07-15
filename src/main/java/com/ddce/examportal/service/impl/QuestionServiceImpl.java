package com.ddce.examportal.service.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddce.examportal.DTO.QuestionDTO;
import com.ddce.examportal.DTO.QuizDTO;
import com.ddce.examportal.entity.exam.Question;
import com.ddce.examportal.entity.exam.Quiz;
import com.ddce.examportal.repositary.QuestionRepositary;
import com.ddce.examportal.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	QuestionRepositary questionRepositary;
	
	@Override
	public Question addQuestion(QuestionDTO quizDTO) {
		Question question = questionDTO_to_Question(quizDTO);
		return questionRepositary.save(question);
	}

	@Override
	public Question updateQuestion(QuestionDTO quizDTO) {
		Question question = questionDTO_to_Question(quizDTO);
		return questionRepositary.save(question);
	}

	@Override
	public Set<Question> getQuestions() {
		return new LinkedHashSet<>(questionRepositary.findAll());
	}

	@Override
	public Question getQuestion(Long id) {
		return questionRepositary.findById(id).get();
	}

	@Override
	public void deleteQuestion(Long id) {
		questionRepositary.deleteById(id);
	}
	
	public Question questionDTO_to_Question(QuestionDTO questionDTO) {
		Question question = new Question();
		question.setTitle(questionDTO.getTitle());
		question.setOptionA(questionDTO.getOptionA());
		question.setOptionB(questionDTO.getOptionB());
		question.setOptionC(questionDTO.getOptionC());
		question.setOptionD(questionDTO.getOptionD());
		question.setAnswer(questionDTO.getAnswer());
		
		return question;
	}

}
