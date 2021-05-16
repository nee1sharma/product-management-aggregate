package com.sharma.nks.products.management.services;

import java.util.List;
import java.util.Optional;

import com.sharma.nks.products.management.model.Product;
import com.sharma.nks.products.management.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.sharma.nks.products.messaging.kafka.MessageProducer;

@Service
public class ProductServiceImpl implements ProductService {

	private final Logger LOGGER= LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private MessageProducer messageProducer;


	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public float getPriceByProductId(Long productId) {

		Optional<Product> optional = productRepository.findById(productId);
		optional.orElseThrow(() -> new ProductNotFoundException("product not found with " + productId));
		return optional.map(Product::getProductId).orElse(productId);

	}
	public Optional<Product> getProductById(Long productId) {
		return productRepository.findById(productId);
	}

	@Override
	public Long saveProduct(Product product) {
		LOGGER.debug("Saving product");
		Long productId = productRepository.save(product).getProductId();
		messageProducer.sendMessage(product);
		return productId;
	}
}
