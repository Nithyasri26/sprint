package com.example.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Course {
	@Id
    private String courseId;
    private String courseName;
    private String description;
    private int price;
    
    @OneToMany
    @JoinColumn(name="courseId")
    private List<Quiz> quizzes;
}
