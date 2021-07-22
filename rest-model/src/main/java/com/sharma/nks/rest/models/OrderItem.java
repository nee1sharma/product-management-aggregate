package com.sharma.nks.rest.models;

import lombok.Data;

@Data
public class OrderItem {
    private String id;
    private String productIdName;
    private int quantity;
    private double unitPrice;
    private double subTotal;
}
