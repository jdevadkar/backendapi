package com.xpx.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xpx.entity.Employee;

@RestController
@RequestMapping("/login")
public class LoginController {

	@PostMapping
	public ResponseEntity<Void> authenticate()
	{
		return null;
	}
	
}
