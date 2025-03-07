package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entities.Employer;

//Provide necessary annotation
@Repository

public interface EmployerRepository  extends JpaRepository<Employer, String> {
//	@Query(value="select * from employer where industry=:industry",nativeQuery = true)
//	List<Employer> viewByIndustryQ(@Param("industry") String industry);
	List<Employer> findByIndustry(String industry);
	List<Employer> findByJobPostingsList_Title(String title);
}