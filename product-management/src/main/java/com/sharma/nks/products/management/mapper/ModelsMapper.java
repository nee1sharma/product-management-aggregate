package com.sharma.nks.products.management.mapper;

import com.sharma.nks.products.management.model.Customer;
import com.sharma.nks.products.management.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ModelsMapper {
    @Mappings({@Mapping(source = "price", target = "maxRetailPrice"),
            @Mapping(source = "id", target = "productId")})
    Product mapProduct(com.sharma.nks.rest.models.Product product);

    @Mappings({@Mapping(source = "maxRetailPrice", target = "price"),
            @Mapping(source = "productId", target = "id")})
    com.sharma.nks.rest.models.Product mapProduct(Product product);

    Customer mapCustomer(com.sharma.nks.rest.models.Customer customer);

    com.sharma.nks.rest.models.Customer mapCustomer(Customer customer);
}
