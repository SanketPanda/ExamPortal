package com.ddce.examportal.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddce.examportal.DTO.QuestionDTO;
import com.ddce.examportal.DTO.QuizDTO;
import com.ddce.examportal.entity.exam.Question;
import com.ddce.examportal.entity.exam.Quiz;
import com.ddce.examportal.repositary.QuestionRepositary;
import com.ddce.examportal.service.QuestionService;
import com.ddce.examportal.service.QuizService;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	QuestionRepositary questionRepositary;
	
	@Autowired
	QuizService quizService;
	
	@Override
	public Question addQuestion(QuestionDTO quizDTO) {
		Question question = questionDTO_to_Question(quizDTO);
		return questionRepositary.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
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
	
	@SuppressWarnings("unchecked")
	@Override
	public Set<Question> getQuestionsOfQuiz(Long quizId) {
		Quiz quiz = this.quizService.getQuiz(quizId);
		Set<Question> quizQuestions = quiz.getQuestions();
		List questionList = new ArrayList<>(quizQuestions);
		if(questionList.size() > quiz.getNoOfQuestion()) {
			questionList = questionList.subList(0, (int) (quiz.getNoOfQuestion()+1));
		}
		Collections.shuffle(questionList);
		return (Set<Question>) questionList;
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
