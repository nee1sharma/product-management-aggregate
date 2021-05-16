package com.sharma.nks.products.management.repository;

import com.sharma.nks.products.management.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, String> {

    List<Order> findOrdersByCustomerId(String customerId);
}
