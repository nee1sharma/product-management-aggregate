package com.sharma.nks.products.management.services;

import com.sharma.nks.products.management.model.Order;
import com.sharma.nks.products.management.model.OrderItem;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    /**
     * Create order for customer id based on order items. Must have at least one item
     * @param orderItems
     * @param customerId
     * @return
     */
    String createOrder(List<OrderItem> orderItems, String customerId);

    Optional<Order> getOrderByOrderId(String orderId);

    List<Order> getOrdersByCustomerId(String customerId);
}
