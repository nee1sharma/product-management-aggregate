package com.sharma.nks.products.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Data
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ElementCollection(fetch = FetchType.LAZY)
    @MapKeyColumn(name="productId")
    @Column(name="units")
    private Map<Long, Integer> productIdToUnits= new HashMap<>();
    private int capacity;
    private Type type;

    @Version
    private long version;

    public enum Type {
        CONSUMER, INDUSTRIAL, SERVICE;
    }

}
