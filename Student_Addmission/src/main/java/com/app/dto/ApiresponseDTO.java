package com.app.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ApiresponseDTO {

	private String msg;
	private LocalDate date;

	public ApiresponseDTO(String msg) {
		this.msg = msg;
		this.date = LocalDate.now();
	}
}
