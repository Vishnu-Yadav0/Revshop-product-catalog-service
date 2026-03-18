package com.revshop.catalogservice.dto;

import java.time.LocalDateTime;

public class ReviewDTO {
    private Long reviewId;
    private Long productId;
    private Long userId;
    private Integer rating;
    private String reviewText;
    private LocalDateTime createdAt;
    private String userName; // For frontend display
    private UserResponse userDetails; // Enhanced in Service via Feign Client

    public ReviewDTO() {}

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserResponse getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserResponse userDetails) {
        this.userDetails = userDetails;
    }
}
