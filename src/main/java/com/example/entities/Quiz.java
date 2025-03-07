package com.example.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Quiz {
	
	@Id
	private String quizId;
	private String courseId;
	private String description;
	private String title;
	private int marks;
	
	@OneToMany
	@JoinColumn(name="quizId")
	private List<Question> questions;

	public String getQuizId() {
		return quizId;
	}

	public void setQuizId(String quizId) {
		this.quizId = quizId;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Quiz(String quizId, String courseId, String description, String title, int marks, List<Question> questions) {
		super();
		this.quizId = quizId;
		this.courseId = courseId;
		this.description = description;
		this.title = title;
		this.marks = marks;
		this.questions = questions;
	}

	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
