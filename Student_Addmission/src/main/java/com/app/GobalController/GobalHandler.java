package com.app.GobalController;

import com.app.dto.ApiresponseDTO;
import com.app.exception.*;

import javax.el.MethodNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GobalHandler {

	@ExceptionHandler(MethodNotFoundException.class)
	public ResponseEntity<?> methodnotfoundexception(MethodNotFoundException m) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new ApiresponseDTO("MethodNotFoundException" + m.getCause()));

	}
	@ExceptionHandler(Studentexception.class)
	public ResponseEntity<?> studentexception(Studentexception s) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiresponseDTO(s.getMessage()));
	}
}
