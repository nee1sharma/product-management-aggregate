package com.sharma.nks.products.management.services;

import com.sharma.nks.products.management.mapper.ModelsMapper;
import com.sharma.nks.products.management.repository.AddressRepository;
import com.sharma.nks.products.management.repository.CustomerRepository;
import com.sharma.nks.products.management.util.UniqueIdGenerator;
import com.sharma.nks.rest.models.Address;
import com.sharma.nks.rest.models.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ModelsMapper mapper;

    @Override
    public String createCustomer(com.sharma.nks.rest.models.Customer customer) {
        customer.setId(UniqueIdGenerator.getUniqueId());
        return customerRepository.save(mapper.mapCustomer(customer)).getCustomerId();
    }

    @Override
    public Optional<Customer> getCustomerById(String customerId) {
        return customerRepository.findById(customerId).map(customer -> mapper.mapCustomer(customer));
    }

    @Override
    public List<Customer> findCustomers() {
        List<com.sharma.nks.products.management.model.Customer> customers = customerRepository.findAll();
        LOGGER.debug("Customers found {}", customers.size());
        return customers.stream().map(customer -> mapper.mapCustomer(customer)).collect(Collectors.toList());
    }

    @Override
    public Customer updateAddress(String customerId, Address address) {
        com.sharma.nks.products.management.model.Address savedAddress = addressRepository.save(mapper.mapAddress(address));
        customerRepository.updateAddress(customerId, savedAddress);
        LOGGER.debug("Address {} updated for customerId: {}", savedAddress.getId(), customerId);
        Optional<com.sharma.nks.products.management.model.Customer> optionalCustomer = customerRepository.findById(customerId);
        return mapper.mapCustomer(optionalCustomer.get());
    }
}
