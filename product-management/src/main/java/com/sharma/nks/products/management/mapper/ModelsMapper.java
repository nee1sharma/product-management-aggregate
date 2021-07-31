package com.sharma.nks.products.management.mapper;

import com.sharma.nks.products.management.model.Address;
import com.sharma.nks.products.management.model.Customer;
import com.sharma.nks.products.management.model.Order;
import com.sharma.nks.products.management.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ModelsMapper {
    @Mappings({@Mapping(source = "price", target = "maxRetailPrice"),
            @Mapping(source = "id", target = "productId")})
    Product mapProduct(com.sharma.nks.rest.models.Product restProduct);

    @Mappings({@Mapping(source = "maxRetailPrice", target = "price"),
            @Mapping(source = "productId", target = "id")})
    com.sharma.nks.rest.models.Product mapProduct(Product product);

    @Mappings({@Mapping(source="id", target = "customerId")})
    Customer mapCustomer(com.sharma.nks.rest.models.Customer restCustomer);

    @Mappings({@Mapping(source="customerId", target = "id")})
    com.sharma.nks.rest.models.Customer mapCustomer(Customer customer);

    @Mappings({@Mapping(source="id", target = "orderId")})
    Order mapOrder(com.sharma.nks.rest.models.Order restOrder);

    @Mappings({@Mapping(source="orderId", target = "id")})
    com.sharma.nks.rest.models.Order mapOrder(Order order);

    Address mapAddress(com.sharma.nks.rest.models.Address address);
}
