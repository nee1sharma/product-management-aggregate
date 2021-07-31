package com.sharma.nks.products.management.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name = "order_table")
public class Order implements Serializable {
    @Id
    private String orderId;

    private String customerId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "orderId")
    private List<OrderItem> orderItems=new ArrayList<>();
    private String status;

    @OneToOne
    // @AttributeOverride(name = "type", column = @Column(name = "order_shipping_address_type"))
    //@AssociationOverride(name = "shippingAddress", joinTable = @JoinTable(name = "order_shipping_address"))
    private Address shippingAddress;

    //@AttributeOverride(name = "type", column = @Column(name = "delivery_address_type"))
    //private Address deliveryAddress;
    private LocalDate orderedDate;
    private LocalDate expectedDeliveryDate;
    private LocalDate deliveredDate;
    private Long totalCost;
    private Long totalDiscount;
    private Long paidAmount;

}
