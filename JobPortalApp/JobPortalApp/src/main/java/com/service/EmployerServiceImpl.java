package com.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.entities.Employer;
import com.entities.JobPost;
import com.exception.InvalidEmployerException;
import com.repository.EmployerRepository;
import com.repository.JobPostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerServiceImpl implements IEmployerService {
		// Provide necessary Annotation
		@Autowired
		private EmployerRepository empRepository;
		@Autowired
		private JobPostRepository jobRepo;

		public Employer addEmployer(Employer employerObj) {
			return empRepository.save(employerObj);
		}
		
		public Employer updateLocation(String employerId, String location) throws InvalidEmployerException
		{
			Optional<Employer> e=empRepository.findById(employerId);
			if(e.isPresent()) {
				Employer emp=e.get();
				emp.setLocation(location);
				empRepository.save(emp);
				return emp;
			}
			else throw new InvalidEmployerException();
			
		}
		
		public Employer viewEmployerById(String employerId) throws InvalidEmployerException
		{
			Optional<Employer> e=empRepository.findById(employerId);
			if(e.isPresent()) {
				return e.get();
			}
			else throw new InvalidEmployerException();
		}
		
		public List<Employer> viewEmployersByIndustry(String industry)
		{
			return empRepository.findByIndustry(industry);
		}
		
		public List<Employer> viewEmployersByJobTitle(String title){
			return empRepository.findByJobPostingsList_Title(title);
		}
		
		public Map<String,Integer> getEmployerWiseJobCount(){
			return null;
		}
		
}
