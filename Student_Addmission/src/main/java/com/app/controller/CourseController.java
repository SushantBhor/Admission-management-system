package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiresponseDTO;
import com.app.dto.CourseDetailsDTO;
import com.app.entities.Course;
import com.app.entities.Student;
import com.app.service.CourseServiceImpl;

@RestController
@RequestMapping("/courses")
@CrossOrigin(origins = "http://localhost:3000")
public class CourseController {
	@Autowired
	private CourseServiceImpl cpser;

	@PostMapping
	public ResponseEntity<?> Insertion(@RequestBody @Valid CourseDetailsDTO c) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ApiresponseDTO(cpser.Courseinsertion(c)));
	}

	@GetMapping("/course_title/{course}")
	public ResponseEntity<?> Getstudent(@PathVariable String course) {

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(cpser.getstudent(course));
	}

	@PutMapping("/courses/{cid}/fees/{fee}")
	public ResponseEntity<?> updateCourse(@PathVariable Long cid, @PathVariable double fee) {
		return ResponseEntity.status(HttpStatus.OK).body(cpser.updatecourse(cid, fee));
	}

	@DeleteMapping("/{cid}/students/{sid}")
	public ResponseEntity<?> Canceladmission(@PathVariable Long cid, @PathVariable Long sid) {
		return ResponseEntity.status(HttpStatus.OK).body(cpser.Canceladmission(cid, sid));
	}

}
