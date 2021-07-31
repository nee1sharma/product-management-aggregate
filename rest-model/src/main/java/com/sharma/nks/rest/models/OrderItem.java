package com.sharma.nks.rest.models;

import lombok.Data;
import lombok.NonNull;

@Data
public class OrderItem {
    private String id;
    @NonNull
    private String productIdName;
    private int quantity;
    private double unitPrice;
    private double subTotal;
}
