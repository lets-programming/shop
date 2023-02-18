package com.letsprogramming.shop.controller;

import com.letsprogramming.shop.domain.Product;
import com.letsprogramming.shop.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;

    @GetMapping("/getProducts")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping("/saveProduct")
    public void saveProduct(Product product) {
        productService.saveProduct(product);
    }
}
