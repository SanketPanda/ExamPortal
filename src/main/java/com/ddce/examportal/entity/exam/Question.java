package com.ddce.examportal.entity.exam;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ddce.examportal.entity.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "question")
@Getter
@Setter
public class Question extends BaseEntity<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long questionId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "option_a")
	private String optionA;
	
	@Column(name = "option_b")
	private String optionB;
	
	@Column(name = "option_c")
	private String optionC;
	
	@Column(name = "option_d")
	private String optionD;
	
	@Column(name = "answer")
	private String answer;
	
	private byte[] image;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Quiz quiz;

	@Override
	public Long getId() {
		return getQuestionId();
	}
	
}
