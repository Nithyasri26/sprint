package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, String>{

}
