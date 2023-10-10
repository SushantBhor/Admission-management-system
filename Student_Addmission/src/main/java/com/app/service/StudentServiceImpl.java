package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.StudentDetails;
import com.app.entities.Course;
import com.app.entities.Student;
import com.app.exception.Studentexception;
import com.app.reppositroy.CourseRepository;
import com.app.reppositroy.StudnetRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudnetRepository srepo;
	@Autowired
	private CourseRepository crepo;
	@Autowired
	private ModelMapper mp;

	public StudentDetails Studentinsertion(StudentDetails s) {

		Course c = crepo.findByCtitle(s.getCourse()).orElseThrow(() -> new Studentexception("No Course Found"));
		Student s1 = mp.map(s, Student.class);
		// System.out.println(s.getScore() + " " + c.getScore());
		if (s.getScore() > c.getScore()) {
			c.addstudent(s1);
			Student s2 = srepo.save(s1);
			StudentDetails r = mp.map(s2, StudentDetails.class);
			return r;
		}
		throw new Studentexception("Student Not Inserted Less Score");

	}

}
