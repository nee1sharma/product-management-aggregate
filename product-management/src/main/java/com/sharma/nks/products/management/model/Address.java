package com.sharma.nks.products.management.model;

import lombok.Data;
import lombok.Generated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String houseName;
    private String block;
    private String address;
    private String area;
    private String landmark;
    private String type;
    private String pincode;
    private String city;
    private String state;
}

