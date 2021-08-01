package com.sharma.nks.products.domain.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class OrderItem {
    @Id
    private String id;
    private String productIdName;
    private int quantity;
    private double unitPrice;
    private double subTotal;
}
