package com.product.management.services;

import java.util.List;
import java.util.Optional;

import com.product.management.model.Product;

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
