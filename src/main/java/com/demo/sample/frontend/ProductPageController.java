package com.demo.sample.frontend;

import com.demo.sample.backend.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class ProductPageController {

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/products")
    public String showProductPage(Model model) {
        ResponseEntity<List<Product>> responseEntity = restTemplate.exchange(
                "http://localhost:8080/api/products",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {}
        );
        model.addAttribute("products", responseEntity.getBody());
        return "products";
    }

    @GetMapping("/products/{id}")
    public String showProductPage(@PathVariable long id, Model model) {
        ResponseEntity<Product> responseEntity = restTemplate.exchange(
                "http://localhost:8080/api/products/"+id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Product>() {}
        );
        model.addAttribute("product", responseEntity.getBody());
        return "product";
    }



}
