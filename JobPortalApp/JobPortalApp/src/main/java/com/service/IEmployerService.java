package com.service;

import java.util.List;
import java.util.Map;
import com.entities.Employer;
import com.exception.InvalidEmployerException;

public interface IEmployerService {

	public Employer addEmployer(Employer employerObj);
	public Employer updateLocation(String employerId, String Location) throws InvalidEmployerException;
	public Employer viewEmployerById(String employerId) throws InvalidEmployerException; 
	public List<Employer> viewEmployersByIndustry(String industry);
	public List<Employer> viewEmployersByJobTitle(String title);

	public Map<String,Integer> getEmployerWiseJobCount();

}
