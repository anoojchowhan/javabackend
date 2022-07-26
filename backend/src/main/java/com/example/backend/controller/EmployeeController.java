package com.example.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.backend.model.Employee;
import com.example.backend.repository.EmployeeRepository;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EmployeeController {
	 @Autowired
	  private EmployeeRepository employeeRepository;
	@GetMapping("/emp")
	public ResponseEntity<List<Employee>> getStudent()
	{
		List<Employee> list = this.employeeRepository.findAll();
		if(list.size()<=0)
		{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return  ResponseEntity.of(Optional.of(list));
	}
	
	@PostMapping("/emp")

	public String addEmployee(@RequestBody Employee emp) {
		this.employeeRepository.save(emp);
     return "Added student with id:" + emp.getEmpId();

	}
}
