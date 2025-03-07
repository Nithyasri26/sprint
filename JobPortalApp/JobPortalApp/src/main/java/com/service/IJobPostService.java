package com.service;

import java.util.List;

import com.entities.JobPost;
import com.exception.InvalidEmployerException;
import com.exception.InvalidJobPostException;

public interface IJobPostService {

	public JobPost addJobPost(JobPost jobPostObj, String employerId) throws InvalidEmployerException;
	public JobPost updateOfferedSalary(String jobId, double salaryOffered) throws InvalidJobPostException;
	public List<JobPost> viewJobsBySalaryOffered(double salaryOffered);
	public List<JobPost> viewJobsByCompanyAndLocation(String companyName, String location);
	public JobPost markJobPostAsClosed(String jobId) throws InvalidJobPostException;
	
}
	 	  	      	 		     	     	        	 	
