package com.example.revshopproductcatalogservice.service;

import com.example.revshopproductcatalogservice.client.UserClient;
import com.example.revshopproductcatalogservice.dto.ApiResponse;
import com.example.revshopproductcatalogservice.dto.ReviewDTO;
import com.example.revshopproductcatalogservice.dto.UserResponse;
import com.example.revshopproductcatalogservice.model.Review;
import com.example.revshopproductcatalogservice.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserClient userClient;

    public ReviewService(ReviewRepository reviewRepository, UserClient userClient) {
        this.reviewRepository = reviewRepository;
        this.userClient = userClient;
    }

    public List<ReviewDTO> getReviewsByProductId(Long productId) {
        return reviewRepository.findByProduct_ProductId(productId).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private ReviewDTO mapToDTO(Review review) {
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
            }
        } catch (Exception e) {
            // Log error, continue mapping
        }

        return dto;
    }
}
