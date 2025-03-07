package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Employer;
import com.exception.InvalidEmployerException;
import com.service.IEmployerService;

//Provide necessary Annotation
@RestController
public class EmployerController {

	// Provide necessary Annotation
	@Autowired
	private IEmployerService employerService;
	@PostMapping("/addEmployer")
	public ResponseEntity<Employer> addEmployer(@RequestBody Employer employerObj) {
		return new ResponseEntity<Employer>(employerService.addEmployer(employerObj),HttpStatus.OK);
	}
	@PutMapping("/updateLocation/{employerId}/{location}")
	public ResponseEntity<Employer> updateLocation(@RequestBody @PathVariable String employerId, @PathVariable String location) throws InvalidEmployerException {
		return new ResponseEntity<Employer>(employerService.updateLocation(employerId, location),HttpStatus.OK);
	}
	
	@GetMapping("/viewEmployerById/{employerId}")
	public ResponseEntity<Employer> viewEmployerById(@PathVariable String employerId) throws InvalidEmployerException {
		return new ResponseEntity<Employer>(employerService.viewEmployerById(employerId),HttpStatus.OK);
	}
	@GetMapping("/viewEmployersByIndustry/{industry}")
	public ResponseEntity<List<Employer>> viewEmployersByIndustry(@PathVariable String industry) {
		return new ResponseEntity<List<Employer>>(employerService.viewEmployersByIndustry(industry),HttpStatus.OK);
	}
	@GetMapping("/viewEmployersByJobTitle/{title}")
	public ResponseEntity<List<Employer>> viewEmployersByJobTitle(@PathVariable String title)  {
		return new ResponseEntity<List<Employer>>(employerService.viewEmployersByJobTitle(title),HttpStatus.OK);
	}
	@GetMapping("/getEmployerWiseJobCount")
	public ResponseEntity<Map<String,Integer>> getEmployerWiseJobCount() {
		return new ResponseEntity<Map<String,Integer>>(employerService.getEmployerWiseJobCount(),HttpStatus.OK);
	}

	
}
