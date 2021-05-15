package com.product.management.services;

public class ProductNotFoundException extends RuntimeException {

	private String message;

	public ProductNotFoundException(String message) {
		this.message = message;
	}

}
