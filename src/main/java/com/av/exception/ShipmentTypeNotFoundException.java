package com.av.exception;

public class ShipmentTypeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ShipmentTypeNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	public ShipmentTypeNotFoundException(String message) {
		super(message);
	}
}
