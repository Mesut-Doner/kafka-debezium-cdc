package com.mdoner.kafkadebeziumcdc.service;


import com.mdoner.kafkadebeziumcdc.model.Product;
import com.mdoner.kafkadebeziumcdc.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product updateProduct(Long productId, Product update) {
        Product oldProduct = productRepository.findById(productId).orElse(null);
        oldProduct.setProductName(update.getProductName());
        oldProduct.setPrice(update.getPrice());
        oldProduct.setStock(update.getStock());

        return productRepository.save(oldProduct);
    }
}
