package com.revshop.catalogservice.controller;

import com.revshop.catalogservice.dto.ApiResponse;
import com.revshop.catalogservice.dto.ReviewDTO;
import com.revshop.catalogservice.service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ReviewDTO>> addReview(@Valid @RequestBody ReviewDTO reviewDTO) {
        ReviewDTO saved = reviewService.addReview(reviewDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Review added successfully", saved));
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<ApiResponse<List<ReviewDTO>>> getReviewsByProductId(@PathVariable Long productId) {
        return ResponseEntity.ok(new ApiResponse<>("Reviews fetched successfully", reviewService.getReviewsByProductId(productId)));
    }

    @GetMapping("/product/{productId}/average-rating")
    public ResponseEntity<ApiResponse<Map<String, Object>>> getAverageRating(@PathVariable Long productId) {
        return ResponseEntity.ok(new ApiResponse<>("Average rating fetched", reviewService.getAverageRating(productId)));
    }

    @GetMapping("/check")
    public ResponseEntity<ApiResponse<Map<String, Object>>> checkReviewEligibility(
            @RequestParam Long userId,
            @RequestParam Long productId) {
        return ResponseEntity.ok(new ApiResponse<>("Check complete", reviewService.checkReviewEligibility(userId, productId)));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<ApiResponse<List<ReviewDTO>>> getReviewsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(new ApiResponse<>("Reviews fetched successfully", reviewService.getReviewsByUserId(userId)));
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<ApiResponse<Void>> deleteReview(@PathVariable Long reviewId) {
        reviewService.deleteReview(reviewId);
        return ResponseEntity.ok(new ApiResponse<>("Review deleted successfully", null));
    }
}
