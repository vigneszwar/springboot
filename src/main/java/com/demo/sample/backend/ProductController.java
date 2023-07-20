package com.demo.sample.backend;

import com.demo.sample.backend.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    ArrayList<Product> products;

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok().body(products);
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        for(Product product: products) {
            if(product.getId() == id) {
                return ResponseEntity.ok().body(product);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@Validated @RequestBody Product product) {
        Product newProduct = Product.builder().id(products.size()+1).name(product.getName()).description(product.getDescription()).price(product.getPrice()).build();
        products.add(newProduct);
        return ResponseEntity.created(URI.create("/products/"+newProduct.getId())).body(newProduct);
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> replaceProduct(@PathVariable long id, @Validated @RequestBody Product product) {
        int index = -1;
        for(Product product1: products) {
            if(product1.getId() == id) {
                index = products.indexOf(product1);
            }
        }
        if(index != -1) {
            products.set(index, product);
            return ResponseEntity.ok().body(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable long id) {
        //write logic for delete
        return ResponseEntity.status(204).body(null);
    }

}
