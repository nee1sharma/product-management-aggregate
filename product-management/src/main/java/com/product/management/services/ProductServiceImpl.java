package com.product.management.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.product.management.model.Product;
import com.product.management.repository.ProductRepository;
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
