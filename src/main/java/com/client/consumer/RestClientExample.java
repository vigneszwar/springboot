package com.client.consumer;

import com.demo.sample.backend.model.Product;

import java.io.IOException;

public class RestClientExample {
    public static void main(String[] args) {

        OkHttpClientProxy okHttpClientProxy = new OkHttpClientProxy();
        try {
//            Product product = Product.builder().name("Redmi Note 12 pro", "8GB RAM and 128GB Storage", 21000).build();
//            okHttpClientProxy.post("http://localhost:8080/products", product);
            Product product = Product.builder().name("Redmi Note 12 pro 5G").description("8GB RAM and 128GB Storage").price(23000).build();
            okHttpClientProxy.put("http://localhost:8080/products/2", product);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
