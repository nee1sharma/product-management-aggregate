package com.sharma.nks.products.management.services;

import com.sharma.nks.products.management.mapper.ModelsMapper;
import com.sharma.nks.products.domain.model.Product;
import com.sharma.nks.products.management.repository.ProductRepository;
import com.sharma.nks.products.messaging.kafka.MessageProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MessageProducer messageProducer;

    @Autowired
    private ModelsMapper modelsMapper;

    public List<com.sharma.nks.products.rest.models.Product> getAllProducts() {

        return productRepository.findAll().stream().map(p -> modelsMapper.mapProduct(p)).collect(Collectors.toList());
    }

    public float getPriceByProductId(Long productId) {

        Optional<Product> optional = productRepository.findById(productId);
        optional.orElseThrow(() -> new ProductNotFoundException("product not found with " + productId));
        return optional.map(Product::getProductId).orElse(productId);

    }

    public Optional<com.sharma.nks.products.rest.models.Product> getProductById(Long productId) {
        return productRepository.findById(productId).map(p -> modelsMapper.mapProduct(p));
    }

    @Override
    public com.sharma.nks.products.rest.models.Product saveProduct(com.sharma.nks.products.rest.models.Product product) {
        LOGGER.debug("Saving product");
        Long productId = productRepository.save(modelsMapper.mapProduct(product)).getProductId();
        product.setId(productId);

        //store in inventory based on category
        messageProducer.sendMessage(product);
        return product;
    }

    @Override
    public List<com.sharma.nks.products.rest.models.Product> saveProductInBulk(List<com.sharma.nks.products.rest.models.Product> products) {
        return products.stream().map(this::saveProduct).collect(Collectors.toList());
    }
}
