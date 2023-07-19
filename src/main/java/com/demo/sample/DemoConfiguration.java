package com.demo.sample;

import com.demo.sample.model.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class DemoConfiguration {
    @Bean
    public ArrayList<Product> getProducts() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Samsung NEO QLED TV", "55 inch 2022 model", 150000));
        products.add(new Product(2, "LG Front Door Washing Machine", "9kg 5 star model", 40000));
        return products;
    }
}
