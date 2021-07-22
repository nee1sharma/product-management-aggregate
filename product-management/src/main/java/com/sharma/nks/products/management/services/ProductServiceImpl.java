package com.sharma.nks.products.management.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.sharma.nks.products.management.mapper.ModelsMapper;
import com.sharma.nks.products.management.model.Product;
import com.sharma.nks.products.management.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.sharma.nks.products.messaging.kafka.MessageProducer;

@Service
public class ProductServiceImpl implements ProductService {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MessageProducer messageProducer;

    @Autowired
    private ModelsMapper modelsMapper;

    public List<com.sharma.nks.rest.models.Product> getAllProducts() {

        return productRepository.findAll().stream().map(p -> modelsMapper.mapProduct(p)).collect(Collectors.toList());
    }

    public float getPriceByProductId(Long productId) {

        Optional<Product> optional = productRepository.findById(productId);
        optional.orElseThrow(() -> new ProductNotFoundException("product not found with " + productId));
        return optional.map(Product::getProductId).orElse(productId);

    }

    public Optional<com.sharma.nks.rest.models.Product> getProductById(Long productId) {
        return productRepository.findById(productId).map(p -> modelsMapper.mapProduct(p));
    }

    @Override
    public Long saveProduct(com.sharma.nks.rest.models.Product product) {
        System.out.println("mapped modelsMapper : " + modelsMapper.mapProduct(product));
        LOGGER.debug("Saving product");
        Long productId = productRepository.save(modelsMapper.mapProduct(product)).getProductId();
        //messageProducer.sendMessage(product);
        return productId;
    }
}
