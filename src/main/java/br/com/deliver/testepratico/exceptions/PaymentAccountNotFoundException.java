package br.com.deliver.testepratico.exceptions;

public class PaymentAccountNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public PaymentAccountNotFoundException(String msg) {
		super(msg);
	}
}
