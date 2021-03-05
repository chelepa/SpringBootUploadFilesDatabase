package br.com.deliver.testepratico.constants;

public enum ErrorCodes {
	ADDITION_AND_FINES_NOT_FOUND("AdditionAndFines not found"),
	PAYMENT_ACCOUNT_FOUND("Payment Account not found");

	private final String message;

	ErrorCodes(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
