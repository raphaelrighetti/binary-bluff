package io.github.raphaelrighetti.naonaoa.exceptions;

public class ArgumentoInvalidoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ArgumentoInvalidoException() {
		super();
	}
	
	public ArgumentoInvalidoException(String mensagem) {
		super(mensagem);
	}

}
