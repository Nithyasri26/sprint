package com.entities;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;

//Provide necessary Annotation
@Entity
@Data
@AllArgsConstructor
public class Employer {
		
	// Provide necessary Annotation
	@Id
	private String employerId;
	private String companyName;
	private String industry;
	private String location;
	@OneToMany(mappedBy = "employerObj")
	private List<JobPost> jobPostingsList;
	
	public Employer() {
		
	}
}
