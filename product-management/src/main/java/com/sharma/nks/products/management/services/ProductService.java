package com.sharma.nks.products.management.services;

import com.sharma.nks.products.rest.models.Product;

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
	Product saveProduct(Product product);

	/**
	 * Save bulk products in one go
	 * @param List of product
	 * @return productId : productName in Product list
	 */
	List<Product> saveProductInBulk(List<Product> products);
}
