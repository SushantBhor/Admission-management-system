package com.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.dto.ApiresponseDTO;
import com.app.dto.CourseDetailsDTO;
import com.app.entities.Student;
import com.app.exception.Studentexception;

public interface CourseService {

	 String Courseinsertion(CourseDetailsDTO c) throws Studentexception;
	
	 List<Student> getstudent(String course);
	 
	 ApiresponseDTO updatecourse(Long cid, double fee);
	 
	 ApiresponseDTO Canceladmission(Long cid, Long sid);
}
