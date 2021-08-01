package com.sharma.nks.products.rest.models;

import lombok.Data;

import java.io.Serializable;


@Data
public class Product implements Serializable {

    private Long id;
    private String name;
    private String category;
    private String size;
    private String brand;
    private Long price;
    private Long discount;

}
