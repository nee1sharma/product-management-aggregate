package com.sharma.nks.products.management;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@TestPropertySource(locations = "/application-dev.yaml")
@SpringBootTest
public class ProductManagementApplicationTest {

    @Test
    void contextLoads() {
    }

}