package com.xpx.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xpx.dao.EmployeeRepository;
import com.xpx.entity.Employee;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository empRepo;
	
	
	@GetMapping
	public List<Employee> getEmployees() {
		System.out.println("  regiter method ");
		
		return null;
	}
	
	@PostMapping
	public Employee createEmployee(@RequestBody Employee emp)
	{
		System.out.println("Employee created"+emp);
		Employee employee =empRepo.save(emp);
		return employee ;
		
	}

}
