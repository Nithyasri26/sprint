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

}
