package com.app.reppositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Student;


@Repository
public interface StudnetRepository extends JpaRepository<Student, Long>{

}
