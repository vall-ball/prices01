package ru.vallball.prices01.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;

import java.sql.SQLException;


@RestControllerAdvice
public class MyExceptionHandler {
	@ExceptionHandler(value = { SQLException.class, ConstraintViolationException.class })
	public ResponseEntity<String> notFoundException(Exception exception) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
	}
}
