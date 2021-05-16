package com.sharma.nks.products.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({"com.sharma.nks.products"})
public class ProductManagementApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProductManagementApplication.class, args);
	}

}
