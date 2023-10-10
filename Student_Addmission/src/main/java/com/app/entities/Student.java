package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "course")
public class Student extends BaseEntity{

	@Column(length = 20,nullable = false)
	private String first_name;
	@Column(length = 20,nullable = false)
	private String last_name;
	@Column(length = 50,unique = true)
	private String email;
	private double score;
	@ManyToOne
	@JoinColumn(name="course")
	private Course course;	
}
