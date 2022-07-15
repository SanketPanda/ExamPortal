package com.ddce.examportal.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ddce.examportal.entity.exam.Question;

@Repository
public interface QuestionRepositary extends JpaRepository<Question, Long>{

}
