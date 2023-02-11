package com.letsprogramming.shop.service;

import com.letsprogramming.shop.domain.Product;
import com.letsprogramming.shop.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProductServiceTest {

    @Test
    @DisplayName("상품 목록 기본 확인")
    void getProducts() {
        Product product = new Product();
        product.setProductIndex(1L);
        product.setTitle("테스트 상품");
        product.setPrice(500);
        product.setImagePath(null);
        List<Product> productList = List.of(product);

        ProductRepository productRepository = mock(ProductRepository.class);
        when(productRepository.findAll()).thenReturn(productList);

        ProductService productService = new ProductService(productRepository);
        List<Product> resultList = productService.getProducts();
        assertNotNull(resultList);
        assertEquals(1L, resultList.size());
        assertEquals(1L, resultList.get(0).getProductIndex());
    }
}