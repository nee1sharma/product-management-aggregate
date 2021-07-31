package com.sharma.nks.products.management.repository;

import com.sharma.nks.products.management.model.Address;
import com.sharma.nks.products.management.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    @Transactional
    @Modifying
    @Query("update Customer set house= :address where customerId= :customerId")
    void updateAddress(String customerId, Address address);
}
