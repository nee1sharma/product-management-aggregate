package com.sharma.nks.products.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories
@EntityScan({"com.sharma.nks.products.domain.model"})
@ComponentScan(basePackages = {"com.sharma.nks.products"})
public class ProductManagementApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProductManagementApplication.class, args);
	}

}
