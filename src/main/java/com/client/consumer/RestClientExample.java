package com.client.consumer;

import com.demo.sample.model.Product;
import okhttp3.*;

import java.io.IOException;

public class RestClientExample {
    public static void main(String[] args) {

        OkHttpClientProxy okHttpClientProxy = new OkHttpClientProxy();
        try {
            Product product = new Product(0, "Redmi Note 12 pro", "8GB RAM and 128GB Storage", 21000);
            okHttpClientProxy.post("http://localhost:8080/products", product);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
