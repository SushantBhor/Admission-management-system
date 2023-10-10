package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CourseDetailsDTO 
{
	@NotBlank(message ="No couse_title INPUT")
	private String ctitle;	
	private LocalDate start_date;
	private LocalDate end_date;
	private double fees;
	private double score;
}
