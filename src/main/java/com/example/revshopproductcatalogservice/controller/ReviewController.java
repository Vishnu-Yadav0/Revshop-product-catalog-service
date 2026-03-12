package com.example.revshopproductcatalogservice.controller;

import com.example.revshopproductcatalogservice.dto.ApiResponse;
import com.example.revshopproductcatalogservice.dto.ReviewDTO;
import com.example.revshopproductcatalogservice.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<ApiResponse<List<ReviewDTO>>> getReviewsByProductId(@PathVariable Long productId) {
        return ResponseEntity.ok(new ApiResponse<>("Reviews fetched successfully", reviewService.getReviewsByProductId(productId)));
    }
}
