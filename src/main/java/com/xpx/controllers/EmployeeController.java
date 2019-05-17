package com.xpx.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.xpx.dao.EmployeeRepository;
import com.xpx.entity.Employee;

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin()
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository empRepo;

	// returns all registered employees
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees() {

		List<Employee> empList = new ArrayList<>();
		Iterable<Employee> empItr = empRepo.findAll();
		empItr.forEach((e) -> empList.add(e));
		System.out.println("EmpList" + empList);
		return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);
	}

	// Creates and Returns an Employee object if not registered already (with
	// email) Or returns with response code Not Acceptable.

	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp) {
		if (null == empRepo.findByEmail(emp.getEmail())) {

			System.out.println("Employee created" + emp);
			Employee employee = empRepo.save(emp);
			ResponseEntity<Employee> res = new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
			return res;
		} else {
			return new ResponseEntity<Employee>(HttpStatus.NOT_ACCEPTABLE);
		}

	}

	//Returns the Employee currently in session
	@GetMapping("/info")
	public ResponseEntity<Employee> userInfo(@SessionAttribute("employee") Employee employee) {

		ResponseEntity<Employee> res = new ResponseEntity<Employee>(employee, HttpStatus.OK);

		return res;
	}
	
	
}
