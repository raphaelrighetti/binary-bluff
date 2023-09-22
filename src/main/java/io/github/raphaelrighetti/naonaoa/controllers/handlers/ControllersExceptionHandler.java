package io.github.raphaelrighetti.naonaoa.controllers.handlers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.github.raphaelrighetti.naonaoa.exceptions.EntidadeNaoEncontradaException;

@RestControllerAdvice
public class ControllersExceptionHandler {

	@ExceptionHandler(EntidadeNaoEncontradaException.class)
	public ResponseEntity<ErroGenericoDTO> entidadeNaoEncontradaException(EntidadeNaoEncontradaException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
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
