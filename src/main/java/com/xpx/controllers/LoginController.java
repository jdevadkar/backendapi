package com.xpx.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.xpx.dao.EmployeeRepository;
import com.xpx.entity.Employee;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/login")
@SessionAttributes("employee")
public class LoginController {

	@Autowired
	EmployeeRepository empRepo;	
	
	// Returns an Employee object if authenticated Or returns with response code not found.
	 
	@PostMapping
	public ResponseEntity<Employee> authenticate(HttpServletRequest request ,@RequestBody Employee employee) {

		Employee emp = empRepo.findByEmail(employee.getEmail());

		if (null == emp) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		} else if (!emp.getPassword().equals(employee.getPassword())) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		} else {
			//sessionEmp =emp;
			request.getSession().setAttribute("employee", emp);
			return new ResponseEntity<Employee>(emp, HttpStatus.OK);		
			
			
		}
	}

}
