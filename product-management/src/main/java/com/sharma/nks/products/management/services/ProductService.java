package com.sharma.nks.products.management.services;

import com.sharma.nks.rest.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
	List<Product> getAllProducts();
	Optional<Product> getProductById(Long productId);

	/**
	 * Save a new product in repository
	 * @param product
	 * @return
	 */
    Long saveProduct(Product product);
}
