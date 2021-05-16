package com.sharma.nks.products.management.repository;

import com.sharma.nks.products.management.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
