package com.letsprogramming.shop.controller;

import com.letsprogramming.shop.service.ReviewService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest({ReviewController.class})
class ReviewControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ReviewService reviewService;

    @Test
    @DisplayName("평범한 저장")
    void saveReview_success() throws Exception {
        mvc.perform(post("/saveReview")
                .param("productIndex", "1000")
                .param("content", "테스트입니다."))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("내용 전달인자 없음")
    void saveReview_emptyContent() throws Exception {
        mvc.perform(post("/saveReview")
                        .param("productIndex", "1000"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("내용이 공백")
    void saveReview_spaceContent() throws Exception {
        mvc.perform(post("/saveReview")
                        .param("productIndex", "1000")
                        .param("content", "    "))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("지정된 상품 이상함")
    void saveReview_invalidProductIndex() throws Exception {
        mvc.perform(post("/saveReview")
                        .param("productIndex", "0")
                        .param("content", "테스트입니다."))
                .andExpect(status().isBadRequest());
    }
}