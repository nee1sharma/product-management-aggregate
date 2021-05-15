package com.product.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.management.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
	
	

}
