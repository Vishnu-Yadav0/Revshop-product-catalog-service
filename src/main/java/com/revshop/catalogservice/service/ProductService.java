package com.revshop.catalogservice.service;

import com.revshop.catalogservice.client.UserClient;
import com.revshop.catalogservice.dto.ApiResponse;
import com.revshop.catalogservice.dto.ProductDTO;
import com.revshop.catalogservice.dto.ProductVideoDTO;
import com.revshop.catalogservice.dto.UserResponse;
import com.revshop.catalogservice.dto.CategoryDTO;
import com.revshop.catalogservice.model.Product;
import com.revshop.catalogservice.repository.ProductRepository;
import com.revshop.catalogservice.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final UserClient userClient;

    public ProductService(ProductRepository productRepository, UserClient userClient) {
        this.productRepository = productRepository;
        this.userClient = userClient;
    }

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
        return mapToDTO(product);
    }

    public List<ProductDTO> getProductsByCategory(Long categoryId) {
        return productRepository.findByCategory_CategoryId(categoryId).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<ProductDTO> getProductsBySeller(Long sellerId) {
        return productRepository.findBySellerId(sellerId).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private ProductDTO mapToDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setProductId(product.getProductId());
        dto.setSellerId(product.getSellerId());
        
        try {
            ApiResponse<UserResponse> userResponse = userClient.getUserById(product.getSellerId());
            if (userResponse != null && userResponse.getData() != null) {
                dto.setSellerDetails(userResponse.getData());
            }
        } catch (Exception e) {
            // Log error, continue mapping without seller details
        }

        if (product.getCategory() != null) {
            dto.setCategoryId(product.getCategory().getCategoryId());
            CategoryDTO catDto = new CategoryDTO();
            catDto.setCategoryId(product.getCategory().getCategoryId());
            catDto.setName(product.getCategory().getName());
            dto.setCategory(catDto);
        }

        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setMrp(product.getMrp());
        dto.setSellingPrice(product.getSellingPrice());
        dto.setStockQuantity(product.getStockQuantity());
        dto.setThresholdQuantity(product.getThresholdQuantity());
        dto.setIsActive(product.getIsActive());
        dto.setImageUrl(product.getImageUrl());
        dto.setAdditionalImages(product.getAdditionalImages());
        dto.setAttributes(product.getAttributes());

        if (product.getProductVideos() != null) {
            dto.setProductVideos(product.getProductVideos().stream().map(v -> {
                ProductVideoDTO vDto = new ProductVideoDTO();
                vDto.setVideoId(v.getVideoId());
                vDto.setVideoUrl(v.getVideoUrl());
                vDto.setVideoType(v.getVideoType());
                return vDto;
            }).collect(Collectors.toList()));
        }

        return dto;
    }
}
