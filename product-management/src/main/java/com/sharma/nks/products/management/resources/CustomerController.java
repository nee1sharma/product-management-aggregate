package com.sharma.nks.products.management.resources;

import com.sharma.nks.products.management.model.Customer;
import com.sharma.nks.products.management.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public String registerCustomer(@RequestBody Customer customer){

       return customerService.createCustomer(customer);
    }

    @GetMapping("/{customerId}")
    public Optional<Customer> getCustomerById(@PathVariable("customerId") String customerId){
        return customerService.getCustomerById(customerId);
    }
}
