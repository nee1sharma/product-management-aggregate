package com.sharma.nks.products.management.services;

import com.sharma.nks.products.management.model.Customer;
import com.sharma.nks.products.management.repository.CustomerRepository;
import com.sharma.nks.products.management.util.UniqueIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public String createCustomer(Customer customer) {
        customer.setCustomerId(UniqueIdGenerator.getUniqueId());
        return customerRepository.save(customer).getCustomerId();
    }

    @Override
    public Optional<Customer> getCustomerById(String customerId) {
        return Optional.of(customerRepository.getOne(customerId));
    }
}
