package com.sharma.nks.products.rest.models;

import lombok.Data;


@Data
public class Address {
    private Long id;
    private String houseName;
    private String block;
    private String address;
    private String area;
    private String landmark;
    private String type;
    private int pincode;
    private String city;
    private String state;
}

