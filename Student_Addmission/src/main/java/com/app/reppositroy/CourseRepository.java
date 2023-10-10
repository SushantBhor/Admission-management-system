package com.app.reppositroy;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.entities.Course;
import java.lang.String;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long>{
		
		Optional<Course> findByCtitle(String c);
}
