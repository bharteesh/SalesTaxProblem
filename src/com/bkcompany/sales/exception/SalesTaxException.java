package com.bkcompany.sales.exception;

public class SalesTaxException extends Exception {

	private static final long serialVersionUID = 1L;

	public SalesTaxException() {
		super();
	}

	public SalesTaxException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SalesTaxException(String message, Throwable cause) {
		super(message, cause);
	}

	public SalesTaxException(String message) {
		super(message);
	}

	public SalesTaxException(Throwable cause) {
		super(cause);
	}
	
	

}
