package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entities.JobPost;
import com.exception.InvalidEmployerException;
import com.exception.InvalidJobPostException;
import com.service.IJobPostService;

//Provide necessary Annotation
@RestController
public class JobPostController {

	// Provide necessary Annotation
	@Autowired
	private IJobPostService jobPostService;
	@PostMapping("/addJobPost/{employerId}")
	public ResponseEntity<JobPost> addJobPost(@RequestBody JobPost jobPostObj, @PathVariable String employerId) throws InvalidEmployerException {
		return new ResponseEntity<JobPost>(jobPostService.addJobPost(jobPostObj, employerId),HttpStatus.OK);
	}
	@PutMapping("/updateOfferedSalary/{jobId}/{salaryOffered}")
	public ResponseEntity<JobPost> updateOfferedSalary( @RequestBody @PathVariable String jobId, @PathVariable double salaryOffered) throws InvalidJobPostException{
		return new ResponseEntity<JobPost>(jobPostService.updateOfferedSalary(jobId, salaryOffered),HttpStatus.OK);
	}
	@GetMapping("/viewJobsBySalaryOffered/{salaryOffered}")
	public ResponseEntity<List<JobPost>> viewJobsBySalaryOffered(@PathVariable double salaryOffered) {
		return new ResponseEntity<List<JobPost>>(jobPostService.viewJobsBySalaryOffered(salaryOffered),HttpStatus.OK);
	}
	@GetMapping("/viewJobsByCompanyAndLocation/{companyName}/{location}")
	public ResponseEntity<List<JobPost>> viewJobsByCompanyAndLocation(@PathVariable String companyName,@PathVariable String location) {
		return new ResponseEntity<List<JobPost>>(jobPostService.viewJobsByCompanyAndLocation(companyName, location),HttpStatus.OK);
	}
	@DeleteMapping("/markJobPostAsClosed/{jobId}")
	public ResponseEntity<JobPost> markJobPostAsClosed(@PathVariable String jobId) throws InvalidJobPostException {
		return new ResponseEntity<JobPost>(jobPostService.markJobPostAsClosed(jobId),HttpStatus.OK);
	}
	
}
