package com.sharma.nks.products.management.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Customer {

    @Id
    private String customerId;
    private String name;
    private String email;
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    private Address house;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "customerId")
    List<Order> orders=new ArrayList<>();
}
