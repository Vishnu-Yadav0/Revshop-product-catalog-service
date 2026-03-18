package com.revshop.catalogservice.service;

import com.revshop.catalogservice.client.SalesClient;
import com.revshop.catalogservice.client.UserClient;
import com.revshop.catalogservice.dto.ApiResponse;
import com.revshop.catalogservice.dto.ReviewDTO;
import com.revshop.catalogservice.dto.UserResponse;
import com.revshop.catalogservice.exception.ResourceNotFoundException;
import com.revshop.catalogservice.model.Product;
import com.revshop.catalogservice.model.Review;
import com.revshop.catalogservice.repository.ProductRepository;
import com.revshop.catalogservice.repository.ReviewRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    private static final Logger log = LoggerFactory.getLogger(ReviewService.class);

    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;
    private final UserClient userClient;
    private final SalesClient salesClient;

    public ReviewService(ReviewRepository reviewRepository, ProductRepository productRepository, UserClient userClient, SalesClient salesClient) {
        this.reviewRepository = reviewRepository;
        this.productRepository = productRepository;
        this.userClient = userClient;
        this.salesClient = salesClient;
    }

    public List<ReviewDTO> getReviewsByProductId(Long productId) {
        return reviewRepository.findByProduct_ProductId(productId).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<ReviewDTO> getReviewsByUserId(Long userId) {
        return reviewRepository.findByUserId(userId).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public ReviewDTO addReview(ReviewDTO dto) {
        log.info("Adding review for product {} by user {}", dto.getProductId(), dto.getUserId());
        
        // Check if user has purchased the product
        ApiResponse<Boolean> purchaseResponse = salesClient.checkPurchase(dto.getUserId(), dto.getProductId());
        if (purchaseResponse == null || purchaseResponse.getData() == null || !purchaseResponse.getData()) {
            throw new RuntimeException("Only verified buyers can review this product");
        }

        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        Review review = new Review();
        review.setProduct(product);
        review.setUserId(dto.getUserId());
        review.setRating(dto.getRating());
        review.setReviewText(dto.getReviewText());

        return mapToDTO(reviewRepository.save(review));
    }

    @Transactional
    public void deleteReview(Long reviewId) {
        log.info("Deleting review id={}", reviewId);
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found"));
        reviewRepository.delete(review);
    }

    public Map<String, Object> getAverageRating(Long productId) {
        Double avg = reviewRepository.getAverageRatingByProductId(productId);
        Long count = reviewRepository.getReviewCountByProductId(productId);

        Map<String, Object> result = new HashMap<>();
        result.put("averageRating", avg != null ? Math.round(avg * 10.0) / 10.0 : 0.0);
        result.put("reviewCount", count != null ? count : 0);
        return result;
    }

    public Map<String, Object> checkReviewEligibility(Long userId, Long productId) {
        boolean hasReviewed = reviewRepository.findByProduct_ProductIdAndUserId(productId, userId).isPresent();
        
        boolean hasPurchased = false;
        try {
            ApiResponse<Boolean> response = salesClient.checkPurchase(userId, productId);
            if (response != null && response.getData() != null) {
                hasPurchased = response.getData();
            }
        } catch (Exception e) {
            log.error("Error checking purchase eligibility: {}", e.getMessage());
        }

        Map<String, Object> eligibility = new HashMap<>();
        eligibility.put("hasReviewed", hasReviewed);
        eligibility.put("hasPurchased", hasPurchased);
        eligibility.put("canReview", hasPurchased && !hasReviewed); 
        
        return eligibility;
    }

    public ReviewDTO mapToDTO(Review review) {
        ReviewDTO dto = new ReviewDTO();
        dto.setReviewId(review.getReviewId());
        dto.setProductId(review.getProduct().getProductId());
        dto.setUserId(review.getUserId());
        dto.setRating(review.getRating());
        dto.setReviewText(review.getReviewText());
        dto.setCreatedAt(review.getCreatedAt());

        try {
            ApiResponse<UserResponse> userResponse = userClient.getUserById(review.getUserId());
            if (userResponse != null && userResponse.getData() != null) {
                dto.setUserDetails(userResponse.getData());
                dto.setUserName(userResponse.getData().getName());
            }
        } catch (Exception e) {
            log.debug("Could not fetch user details for userId={}: {}", review.getUserId(), e.getMessage());
        }

        return dto;
    }
}
