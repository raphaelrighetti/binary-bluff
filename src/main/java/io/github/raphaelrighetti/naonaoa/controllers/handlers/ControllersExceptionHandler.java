package io.github.raphaelrighetti.naonaoa.controllers.handlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ControllersExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Void> entityNotFoundException() {
		return ResponseEntity.notFound().build();
	}
	
}
