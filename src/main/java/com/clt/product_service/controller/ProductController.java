package com.clt.product_service.controller;

import com.clt.product_service.entity.Product;
import com.clt.product_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // create a product
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }
    //get All Product
    @GetMapping
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    //Get mapping by ID
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
        Product product = productRepository.findById(Math.toIntExact(productId)).orElseThrow(()-> new RuntimeException("product not found with ID: "+productId));
        return ResponseEntity.ok(product);
    }
}
