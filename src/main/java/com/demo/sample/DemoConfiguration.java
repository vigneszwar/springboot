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
        products.add(Product.builder().id(1).name("Samsung NEO QLED TV").description("55 inch 2022 model").price(150000).build());
        products.add(Product.builder().id(2).name("LG Front Door Washing Machine").description("9kg 5 star model").price(150000).build());
        return products;
    }
}
