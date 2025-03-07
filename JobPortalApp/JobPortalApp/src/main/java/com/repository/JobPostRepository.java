package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entities.JobPost;

//Provide necessary annotation
@Repository
public interface JobPostRepository extends JpaRepository<JobPost,String>{

//	 Provide necessary method methods to view JobPosts by salaryOffered, and view 
//	JobPosts by companyName and location
	List<JobPost> findBySalaryOfferedGreaterThanEqual(double salary);
	List<JobPost> findByEmployerObj_CompanyNameAndEmployerObj_Location(String companyName, String location);

}