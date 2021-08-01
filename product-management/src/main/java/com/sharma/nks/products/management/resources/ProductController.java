package com.sharma.nks.products.management.resources;

import com.sharma.nks.products.management.services.ProductService;
import com.sharma.nks.products.rest.models.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

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
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        LOGGER.debug("Saving new product: {}", product);
        Product savedProduct = productService.saveProduct(product);
        return ResponseEntity.created(UriComponentsBuilder.newInstance().pathSegment(String.valueOf(savedProduct.getId())).build().toUri())
                .body(savedProduct);
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<Product>> saveProductsBulk(@RequestBody List<Product> products) {
        LOGGER.debug("Storing bulk products {}", products.size());
        List<Product> storedProducts = productService.saveProductInBulk(products);
        LOGGER.debug("{} product stored.", storedProducts.size());
        return ResponseEntity.accepted().body(storedProducts);
    }
}
