package com.demo.springjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springjpa.entity.Employee;
import com.demo.springjpa.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@RequestMapping("/findBySearch")
	public List<Employee> findBySearch(@RequestParam("search") String search){
		
		return employeeRepository.findBySearch(search);
		
	}
	
	@RequestMapping("/setDeleted")
	public void setDeleted(@RequestParam("id") int id){
		
		employeeRepository.setDeleted(id);
		
	}
	
	@RequestMapping("/saveEmployee")
	public void saveEmployee(@RequestBody Employee emp){
		
		employeeRepository.save(emp);
		
	}
	
	@RequestMapping("/getAllEmployees")
	public List<Employee> getAllEmployees(){
		
		return employeeRepository.findAll();
		
	}
	
	@RequestMapping("/deleteEmpbyId")
	public void deleteEmp(@RequestParam("id") int id){
		
		employeeRepository.deleteById(id);
		
	}

}
