package com.letsprogramming.shop.controller;

import com.letsprogramming.shop.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({ProductController.class, ProductService.class}) // TODO 테스트를 위한 클래스를 자동으로 읽어오는 방법을 고민해볼 것
class ProductControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    @DisplayName("상품 목록 기본 동작 확인")
    void getProducts() throws Exception {
        mvc.perform(get("/getProducts"))
                .andExpect(status().isOk());
    }
}