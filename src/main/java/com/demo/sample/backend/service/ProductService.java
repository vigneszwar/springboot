package com.demo.sample.backend.service;

import com.demo.sample.backend.model.Product;
import com.demo.sample.backend.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProduct(long id) {
        return productRepository.findById(id);
    }
    public Product addProduct(Product product) {
        Product newProduct = Product.builder()
                .name(product.getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .imageUrl(product.getImageUrl())
                .build();
        return productRepository.save(newProduct);
    }

    @Transactional
    public Product updateExistingProduct(long id, Product product) {
        Product existingProduct = productRepository.findById(id).orElseThrow();
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setImageUrl(product.getImageUrl());
        return productRepository.save(existingProduct);
    }

    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

}
