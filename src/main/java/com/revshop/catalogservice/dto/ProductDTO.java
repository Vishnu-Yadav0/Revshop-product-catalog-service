package com.revshop.catalogservice.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class ProductDTO {
    private Long productId;
    private Long sellerId;
    private UserResponse sellerDetails; // Enhanced in Service via Feign Client
    private Long categoryId;
    private CategoryDTO category; // Detailed category
    private String categoryName; // Flat field for comparison
    private String sellerName; // Flat field for comparison
    private String name;
    private String description;
    private BigDecimal mrp;
    private BigDecimal sellingPrice;
    private Integer stockQuantity;
    private Integer thresholdQuantity;
    private Boolean isActive;
    private String imageUrl;
    private List<String> additionalImages;
    private Map<String, String> attributes;
    private List<ProductVideoDTO> productVideos;

    public ProductDTO() {}

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public UserResponse getSellerDetails() {
        return sellerDetails;
    }

    public void setSellerDetails(UserResponse sellerDetails) {
        this.sellerDetails = sellerDetails;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getMrp() {
        return mrp;
    }

    public void setMrp(BigDecimal mrp) {
        this.mrp = mrp;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Integer getThresholdQuantity() {
        return thresholdQuantity;
    }

    public void setThresholdQuantity(Integer thresholdQuantity) {
        this.thresholdQuantity = thresholdQuantity;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<String> getAdditionalImages() {
        return additionalImages;
    }

    public void setAdditionalImages(List<String> additionalImages) {
        this.additionalImages = additionalImages;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public List<ProductVideoDTO> getProductVideos() {
        return productVideos;
    }

    public void setProductVideos(List<ProductVideoDTO> productVideos) {
        this.productVideos = productVideos;
    }
}
