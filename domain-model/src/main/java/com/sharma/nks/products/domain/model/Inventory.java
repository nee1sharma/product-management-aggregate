package com.sharma.nks.products.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Data
public class Inventory {
    public static int MAX = 10;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ElementCollection(fetch = FetchType.EAGER)
    @MapKeyColumn(name = "category_id")
    @Column(name = "units")
    @CollectionTable(name="INVENTORY_PRODUCT_CATEGORY", joinColumns = @JoinColumn(name="id"))
    private Map<String, Integer> productCategoryToUnits = new HashMap<>(MAX);
    private int capacity;
    private Type type;

    @Version
    private long version;

    public enum Type {
        CONSUMER, INDUSTRIAL, SERVICE;
    }

}
