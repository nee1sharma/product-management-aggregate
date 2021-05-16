package com.sharma.nks.products.management.repository;

import com.sharma.nks.products.management.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
	
	

}
