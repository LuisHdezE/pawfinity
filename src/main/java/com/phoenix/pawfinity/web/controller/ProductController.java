package com.phoenix.pawfinity.web.controller;

import com.phoenix.pawfinity.domain.Product;
import com.phoenix.pawfinity.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Products")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/all")
    public List<Product> getAll() {
        return service.getAll();
    }

    @GetMapping("/{productId}")
    public Optional<Product> getProduct(@PathVariable("productId") int productId) {
        return service.getProduct(productId);
    }

    @PostMapping("/save")
    public Product save(@RequestBody Product product) {
        return service.save(product);
    }

    @DeleteMapping("/delete/{productId}")
    public boolean delete(@PathVariable("productId") int productId) {
        return service.delete(productId);
    }
}
