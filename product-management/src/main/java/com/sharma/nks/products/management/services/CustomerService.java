package com.sharma.nks.products.management.services;

import com.sharma.nks.products.management.model.Customer;

import java.util.Optional;

public interface CustomerService {
    String createCustomer(Customer customer);

    Optional<Customer> getCustomerById(String customerId);
}
