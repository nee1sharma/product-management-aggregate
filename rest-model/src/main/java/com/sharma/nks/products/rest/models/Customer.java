package com.sharma.nks.products.rest.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Customer {

    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private Address house;

    List<Order> orders=new ArrayList<>();
}
