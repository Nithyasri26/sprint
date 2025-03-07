package com.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizOption {
	
	@Id
	private String OptionId;
	
	private String questionId;
	private String Option1;
	private String Option2;
	private String Option3;
	private String Option4;
}
