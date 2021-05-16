package com.sharma.nks.products.management.services;

import com.sharma.nks.products.management.model.Address;
import com.sharma.nks.products.management.model.Order;
import com.sharma.nks.products.management.model.OrderItem;
import com.sharma.nks.products.management.repository.OrderRepository;
import com.sharma.nks.products.management.util.UniqueIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Value("${app.operator.name}")
    private String operatorPrefix;

    @Override
    public String createOrder(List<OrderItem> orderItems, String customerId) {
        Order order = buildOrder(orderItems, customerId);
        Order save = orderRepository.save(order);
        return save.getOrderId();
    }

    private Order buildOrder(List<OrderItem> orderItems, String customerId) {
        Order order = new Order();
        order.setCustomerId(customerId);
        order.setOrderId(UniqueIdGenerator.getUniqueId(operatorPrefix));
        order.setOrderedDate(LocalDate.now());
        Address shippingAddress=new Address();
        shippingAddress.setAddress(customerId);
        shippingAddress.setId(101L);
        order.setShippingAddress(shippingAddress);
        order.setStatus("delivered");
        order.setOrderItems(orderItems);
        return order;
    }

    @Override
    public Optional<Order> getOrderByOrderId(String orderId) {
        return orderRepository.findById(orderId);
    }

    @Override
    public List<Order> getOrdersByCustomerId(String customerId) {
        return orderRepository.findOrdersByCustomerId(customerId);
    }
}
