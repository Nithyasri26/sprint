package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.QuizOption;

@Repository
public interface QuizOptionRepository extends JpaRepository<QuizOption, String> {

}
