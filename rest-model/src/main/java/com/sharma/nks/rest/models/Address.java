package com.sharma.nks.rest.models;

import lombok.Data;


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

