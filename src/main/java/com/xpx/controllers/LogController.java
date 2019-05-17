package com.xpx.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins="http://localhost:4200")
@CrossOrigin()
@RestController
@RequestMapping("/logs")
public class LogController {
	
	
	//prints logs received by client
	@PostMapping()
	public void getLog(@RequestBody String request) {
		System.out.println(request);
	}

}
