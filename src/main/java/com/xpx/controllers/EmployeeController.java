package com.xpx.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

	// Creates and Returns an Employee object if not registered already (with email) Or returns with response code Not Acceptable.

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
}
