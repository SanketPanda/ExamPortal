package com.ddce.examportal.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuizDTO {
	private String title;

	private String description;

	private long maxMark;

	private long noOfQuestion;

	private boolean active;
}
