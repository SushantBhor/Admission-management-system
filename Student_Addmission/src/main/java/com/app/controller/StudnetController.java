package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiresponseDTO;
import com.app.dto.StudentDetails;
import com.app.service.StudentServiceImpl;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:3000")
public class StudnetController {
	@Autowired
	private StudentServiceImpl sser;

	@PostMapping	
	public ResponseEntity<?> Studentinsertion(@RequestBody StudentDetails s) {
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(sser.Studentinsertion(s));
	}
}
