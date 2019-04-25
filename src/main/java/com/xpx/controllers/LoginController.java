package com.xpx.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xpx.dao.EmployeeRepository;
import com.xpx.entity.Employee;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	EmployeeRepository empRepo;

	
	
	// Returns an Employee object if authenticated Or returns with response code not found.
	 
	@PostMapping
	public ResponseEntity<Employee> authenticate(@RequestBody Employee employee) {

		Employee emp = empRepo.findByEmail(employee.getEmail());

		if (null == emp) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		} else if (!emp.getPassword().equals(employee.getPassword())) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Employee>(emp, HttpStatus.FOUND);
		}
	}

}
