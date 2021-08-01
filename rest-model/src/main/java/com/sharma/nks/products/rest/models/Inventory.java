package com.sharma.nks.products.rest.models;

import lombok.Data;

import java.util.Map;

@Data
public class Inventory {

    private Long id;
    private Map<Long, Integer> productIdToUnits;
    private int capacity;
    private Type type;

    public enum Type {
        CONSUMER, INDUSTRIAL, SERVICE;
    }

}
