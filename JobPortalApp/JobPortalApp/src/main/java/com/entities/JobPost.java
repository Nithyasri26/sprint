package com.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

//Provide necessary Annotation
@Entity
@Data
@AllArgsConstructor
public class JobPost {
	
	// Provide necessary Annotation
	@Id
	private String jobId; 
	
	private String title; 
	private String description; 
	private double salaryOffered;  
	private int requiredExperience; 
	private LocalDate postingDate;
	private String status;
	@ManyToOne
	@JoinColumn(name="employer_id")
	private Employer employerObj; 

	public JobPost() {
		
	}
}

