package org.mma.training.java.springboot.controller;

import java.util.List;

import org.mma.training.java.springboot.model.Employee;
import org.mma.training.java.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@PostMapping("/employee/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		
		return new ResponseEntity<Employee> (employeeRepository.save(employee), HttpStatus.CREATED);
	}
	
	@GetMapping("/employee/get")
	public ResponseEntity<List<Employee>> getEmployee(){
		
		return new ResponseEntity<List<Employee>> (employeeRepository.findAll(), HttpStatus.OK);
	
	} 
	
	
	@GetMapping("/employee/get/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
		
		return new ResponseEntity<Employee> (employeeRepository.findById(id).get(), HttpStatus.OK);
	
	} 
	
	@DeleteMapping("/employee/delete/{id}")
	public String deleteEmployeeById(@PathVariable Long id){
		employeeRepository.deleteById(id);
		return "Succesfully deleted Employee";
	
	} 
}
