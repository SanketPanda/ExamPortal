package com.ddce.examportal.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ddce.examportal.entity.exam.Quiz;

@Repository
public interface QuizRepositary extends JpaRepository<Quiz, Long> {

}
