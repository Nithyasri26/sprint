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
public class Question {
	@Id
	private String questionId;
	private String questionText;
	@OneToMany
	@JoinColumn(name="questionId")
	private List<QuizOption> options;
	private String correctAnswer;

}
