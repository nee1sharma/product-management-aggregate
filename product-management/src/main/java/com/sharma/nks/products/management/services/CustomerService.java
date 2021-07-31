package com.sharma.nks.products.management.services;

import com.sharma.nks.rest.models.Address;
import com.sharma.nks.rest.models.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    String createCustomer(com.sharma.nks.rest.models.Customer customer);

    Optional<Customer> getCustomerById(String customerId);

    List<Customer> findCustomers();

    Customer updateAddress(String customerId, Address address);
}
