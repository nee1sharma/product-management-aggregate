package com.sharma.nks.products.management.model;

import lombok.Data;

import javax.persistence.Embeddable;


@Embeddable
@Data
public class Address {
    private Long id;
    private String type;
    private String address;
    private String area;
    private int pinCode;
    private String nearBy;
    private String phoneNumber;
}

