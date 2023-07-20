package com.client.consumer;

import com.demo.sample.backend.model.Product;

import java.io.IOException;

public class RestClientExample {
    static RestTemplateClient restTemplateClient = new RestTemplateClient();
    public static void main(String[] args) {

//      Product product = Product.builder().name("Redmi Note 12 pro").description("12GB RAM 256GB Storage").price(23000)
//            .imageUrl("https://encrypted-tbn2.gstatic.com/shopping?q=tbn:ANd9GcSh5o9OjxFdIZHRaRWbupmtCSpxEQFOqZULdDAeCy-Y56qUbVz9F1hyrk2lcOe_HGMfmXglEnfDteuSDaqPg_hbjVjrnnoEXnYPYrgbO2vYFD_d7EB6C_Td&usqp=CAc")
//                        .build();
//        Product product = Product.builder().name("Samsung NEO QLED TV").description("55 inch 2022 model").price(150000).imageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS0lZLHGS5Lo-tBrPgAhhs2b_vi78bYMbUoqw&usqp=CAU").build();
        Product product = Product.builder().name("LG Front Door Washing Machine").description("9kg 5 star model").price(150000).imageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRzXYd9QG494vqNiVwO6T2p--Uk-0UXnyq1TwivXZ-oVA&s").build();


        restTemplateClient.addProduct(product);
    }
}
