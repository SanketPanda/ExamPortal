package com.ddce.examportal.repositary;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ddce.examportal.entity.exam.Question;
import com.ddce.examportal.entity.exam.Quiz;

@Repository
public interface QuestionRepositary extends JpaRepository<Question, Long>{
	
	Set<Question> findByQuiz(Quiz quiz);
	
}
