package br.com.deliver.testepratico.exceptions;

public class AdditionAndFinesNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public AdditionAndFinesNotFoundException(String msg) {
		super(msg);
	}
}
