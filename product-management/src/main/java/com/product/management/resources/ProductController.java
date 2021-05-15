package com.product.management.resources;

import com.product.management.model.Product;
import com.product.management.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        LOGGER.info("get All Products");
        List<Product> products = productService.getAllProducts();
        LOGGER.debug("Returning products : {}", products);
        return ResponseEntity.ok(products);

    }

    @GetMapping("/{pid}")
    public Optional<Product> getProductById(@PathVariable("pid") Long productId) {
        return productService.getProductById(productId);
    }

    @PostMapping
    public Long saveProduct(@RequestBody Product product) {
        LOGGER.debug("Saving new product: {}", product);
        return productService.saveProduct(product);
    }
}
