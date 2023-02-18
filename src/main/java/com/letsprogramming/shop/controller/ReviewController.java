package com.letsprogramming.shop.controller;

import com.letsprogramming.shop.domain.Review;
import com.letsprogramming.shop.service.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/saveReview")
    public void saveReview(@Valid Review review) {
        reviewService.saveReview(review);
    }
}
