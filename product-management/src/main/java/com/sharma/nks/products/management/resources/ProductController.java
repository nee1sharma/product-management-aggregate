package com.sharma.nks.products.management.resources;

import com.sharma.nks.products.management.services.ProductService;
import com.sharma.nks.rest.models.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        LOGGER.info("get All Products");
        List<Product> products = productService.getAllProducts();
        LOGGER.debug("Returning products : {}", products);
        return ResponseEntity.ok(products);

    }

    @GetMapping("/{pid}")
    public ResponseEntity<Product> getProductById(@PathVariable("pid") Long productId) {
        return productService.getProductById(productId).map(ResponseEntity::ok).orElse(null);
    }

    @PostMapping
    public ResponseEntity<Long> saveProduct(@RequestBody Product product) {
        LOGGER.debug("Saving new product: {}", product);
        Long id = productService.saveProduct(product);
        return ResponseEntity.created(UriComponentsBuilder.newInstance().pathSegment(String.valueOf(id)).build().toUri()).build();
    }
}
