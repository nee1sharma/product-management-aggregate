package com.sharma.nks.products.management.repository;

import com.sharma.nks.products.management.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
