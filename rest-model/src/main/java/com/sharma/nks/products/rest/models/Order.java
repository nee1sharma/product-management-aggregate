package com.sharma.nks.products.rest.models;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Data
public class Order implements Serializable {

    private String id;
    private String customerId;
    private List<OrderItem> orderItems=new ArrayList<>();
    private String status;
    private Address shippingAddress;
    private LocalDate orderedDate;
    private LocalDate expectedDeliveryDate;
    private LocalDate deliveredDate;
    private Long totalCost;
    private Long totalDiscount;
    private Long paidAmount;
}
