package com.raphaelrighetti.binarybluff.controllers.handlers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.raphaelrighetti.binarybluff.exceptions.ArgumentoInvalidoException;

@RestControllerAdvice
public class ControllersExceptionHandler {
	
	@ExceptionHandler(ArgumentoInvalidoException.class)
	public ResponseEntity<ErroGenericoDTO> argumentoInvalidoException(ArgumentoInvalidoException ex) {
		return ResponseEntity.badRequest()
				.body(new ErroGenericoDTO(ex.getMessage()));
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
	
	private record ErroGenericoDTO(String mensagem) {
		
	}
	
}
