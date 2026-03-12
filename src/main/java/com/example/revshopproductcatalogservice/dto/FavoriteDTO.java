package com.example.revshopproductcatalogservice.dto;

import java.time.LocalDateTime;

public class FavoriteDTO {
    private Long favoriteId;
    private Long buyerId;
    private Long productId;
    private ProductDTO productDetails;
    private LocalDateTime addedAt;

    public FavoriteDTO() {}

    public Long getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(Long favoriteId) {
        this.favoriteId = favoriteId;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public ProductDTO getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(ProductDTO productDetails) {
        this.productDetails = productDetails;
    }

    public LocalDateTime getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(LocalDateTime addedAt) {
        this.addedAt = addedAt;
    }
}
