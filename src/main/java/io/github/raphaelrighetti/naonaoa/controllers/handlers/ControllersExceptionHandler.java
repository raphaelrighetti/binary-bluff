package io.github.raphaelrighetti.naonaoa.controllers.handlers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ControllersExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Void> entityNotFoundException() {
		return ResponseEntity.notFound().build();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<FieldErrorDTO>> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
		List<FieldErrorDTO> fieldErrorDTOs = 
				ex.getFieldErrors().stream().map(FieldErrorDTO::new).toList();
		
		return ResponseEntity.badRequest().body(fieldErrorDTOs);
	}
	
	private record FieldErrorDTO(String campo, String mensagem) {
		
		public FieldErrorDTO(FieldError error) {
			this(error.getField(), error.getDefaultMessage());
		}
		
	}
	
}
