package com.client.consumer;

import com.demo.sample.backend.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateClient {


    public void addProduct() {
        RestTemplate restTemplate = new RestTemplate();
        Product product = Product.builder().name("Redmi Note 12 pro").description("12GB RAM 256GB Storage").price(23000)
            .imageUrl("https://encrypted-tbn2.gstatic.com/shopping?q=tbn:ANd9GcSh5o9OjxFdIZHRaRWbupmtCSpxEQFOqZULdDAeCy-Y56qUbVz9F1hyrk2lcOe_HGMfmXglEnfDteuSDaqPg_hbjVjrnnoEXnYPYrgbO2vYFD_d7EB6C_Td&usqp=CAc")
                        .build();
        restTemplate.postForObject("http://localhost:8080/api/products",product, Product.class);
    }



}
