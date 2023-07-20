package com.client.consumer;

import com.demo.sample.backend.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateClient {
    RestTemplate restTemplate = new RestTemplate();

    public void addProduct(Product product) {
        restTemplate.postForObject("http://localhost:8081/api/products",product, Product.class);
    }

    public void deleteProduct(long id) {
        restTemplate.delete("http://localhost:8081/api/products/" + id);
    }



}
