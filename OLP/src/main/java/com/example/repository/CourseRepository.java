package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {

}
