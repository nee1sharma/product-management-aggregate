package com.sharma.nks.rest.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Customer {

    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    List<Order> orders=new ArrayList<>();
}
