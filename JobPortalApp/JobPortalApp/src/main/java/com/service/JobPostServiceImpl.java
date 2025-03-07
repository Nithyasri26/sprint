package com.service;

import java.util.List;
import java.util.Optional;

import com.entities.Employer;
import com.entities.JobPost;
import com.exception.InvalidEmployerException;
import com.exception.InvalidJobPostException;
import com.repository.EmployerRepository;
import com.repository.JobPostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobPostServiceImpl implements IJobPostService {

	// Provide necessary Annotation
	@Autowired
	private JobPostRepository jobRepository;

	// Provide necessary Annotation
	@Autowired
	private EmployerRepository empRepository;

	public JobPost addJobPost(JobPost jobPostObj, String employerId) throws InvalidEmployerException
	{
		Optional<Employer> e=empRepository.findById(employerId);
		if(e.isPresent()) {
			Employer emp=e.get();
			JobPost jp=new JobPost();
			jp.setDescription(jobPostObj.getDescription());
			jp.setJobId(jobPostObj.getJobId());
			jp.setRequiredExperience(jobPostObj.getRequiredExperience());
			jp.setPostingDate(jobPostObj.getPostingDate());
			jp.setTitle(jobPostObj.getTitle());
			jp.setSalaryOffered(jobPostObj.getSalaryOffered());
			jp.setStatus(jobPostObj.getStatus());
			jp.setEmployerObj(emp);
			jobRepository.save(jp);
			return jp;
		}
		else throw new InvalidEmployerException();
		
	}
	
	public JobPost updateOfferedSalary(String jobId, double salaryOffered) throws InvalidJobPostException
	{
		Optional<JobPost> jp=jobRepository.findById(jobId);
		if(jp.isPresent()) {
			JobPost job=jp.get();
			job.setSalaryOffered(salaryOffered);
			jobRepository.save(job);
			return job;
		}
		else throw new InvalidJobPostException();
	}	
	
	public List<JobPost> viewJobsBySalaryOffered(double salaryOffered)
	{
		return jobRepository.findBySalaryOfferedGreaterThanEqual(salaryOffered);
	}
	
	public List<JobPost> viewJobsByCompanyAndLocation(String companyName, String location){
		
			return jobRepository.findByEmployerObj_CompanyNameAndEmployerObj_Location(companyName, location);
	}
	
	public JobPost markJobPostAsClosed(String jobId) throws InvalidJobPostException {
		Optional<JobPost> j=jobRepository.findById(jobId);
		if(j.isPresent()) {
			JobPost jp=j.get();
			jobRepository.delete(jp);
			return jp;
			
			
		}
		else throw new InvalidJobPostException();
	
	}
}
