package br.com.senac.servico.exception;

public class ObjectNotFoundException extends RuntimeException{
	private static final long serialVersonUID = 1L;
	
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	
	public ObjectNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
	

}
