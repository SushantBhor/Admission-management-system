package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
//course title(unique) , start_date ,  , fees , min score
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "slist")
@JsonIgnoreType
public class Course extends BaseEntity {

	private String ctitle;
	@Column(nullable = false)
	private LocalDate start_date;
	@Column(nullable = false)
	private LocalDate end_date;
	@Column(nullable = false)
	private double fees;
	private double score;
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Student> slist = new ArrayList<>();

	public boolean addstudent(Student s) {
		slist.add(s);
		s.setCourse(this);
		return true;
	}

	public boolean removestudent(Student s) {
		slist.remove(s);
		s.setCourse(null);
		return true;
	}
}
