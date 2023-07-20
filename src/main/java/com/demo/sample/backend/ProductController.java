package com.demo.sample.backend;

import com.demo.sample.backend.model.Product;
import com.demo.sample.backend.service.ProductService;
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
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok().body(productService.getProducts());
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        Product product = productService.getProduct(id).orElse(null);

        if(product != null) {
            return ResponseEntity.ok().body(product);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@Validated @RequestBody Product product) {
        Product newProduct = productService.addProduct(product);
        return ResponseEntity.created(URI.create("/products/"+newProduct.getId())).body(newProduct);
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> replaceProduct(@PathVariable long id, @Validated @RequestBody Product product) {
        Product updatedProduct = null;
        try {
         updatedProduct = productService.updateExistingProduct(id, product);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(updatedProduct);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable long id) {
        try {
            productService.deleteProduct(id);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(204).body(null);
    }

}
