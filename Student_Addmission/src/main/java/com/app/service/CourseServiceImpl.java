package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.ApiresponseDTO;
import com.app.dto.CourseDetailsDTO;
import com.app.entities.Course;
import com.app.entities.Student;
import com.app.exception.Studentexception;
import com.app.reppositroy.CourseRepository;
import com.app.reppositroy.StudnetRepository;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository crepo;

	@Autowired
	private StudnetRepository srepo;
	@Autowired
	private ModelMapper mp;

	public String Courseinsertion(CourseDetailsDTO c) throws Studentexception {

		Course course = mp.map(c, Course.class);
		Course course1 = crepo.save(course);
		if (course1 == null)
			throw new Studentexception("Data Insertion Fail");
		return "Data Insertion Sucessfull";
	}

	public List<Student> getstudent(String course) {
		Course c = crepo.findByCtitle(course).orElseThrow(() -> new Studentexception("No Course Found"));
		// c.getSlist().forEach(System.out::println);
		return c.getSlist();
	}

	public ApiresponseDTO updatecourse(Long cid, double fee) {
		Course c = crepo.findById(cid).orElseThrow(() -> new Studentexception("Course Not Found By ID"));
		c.setFees(fee);
		Course c1 = crepo.save(c);
		if (c1 == null) {
			throw new Studentexception("Error In Course Updatation");
		}
		return new ApiresponseDTO("Course Updated Sucessfully");
	}

	public ApiresponseDTO Canceladmission(Long cid, Long sid) {

		Course c = crepo.findById(cid).orElseThrow(() -> new Studentexception("Course By Id Not Found"));
		Student s = srepo.findById(sid).orElseThrow(() -> new Studentexception("Student By ID Not Exists"));
		c.removestudent(s);
		return new ApiresponseDTO("Student Removed Sucessfully");
	}

}
