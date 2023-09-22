package io.github.raphaelrighetti.naonaoa.exceptions;

public class EntidadeNaoEncontradaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EntidadeNaoEncontradaException() {
		super();
	}
	
	public EntidadeNaoEncontradaException(String entidade) {
		super("Entidade `" + entidade + "` não encontrada");
	}

}
