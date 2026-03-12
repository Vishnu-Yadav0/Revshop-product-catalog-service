package com.revshop.catalogservice.service;

import com.revshop.catalogservice.dto.FavoriteDTO;
import com.revshop.catalogservice.dto.ProductDTO;
import com.revshop.catalogservice.model.Favorite;
import com.revshop.catalogservice.model.Product;
import com.revshop.catalogservice.repository.FavoriteRepository;
import com.revshop.catalogservice.repository.ProductRepository;
import com.revshop.catalogservice.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavoriteService {

    private static final Logger log = LoggerFactory.getLogger(FavoriteService.class);

    private final FavoriteRepository favoriteRepository;
    private final ProductRepository productRepository;

    public FavoriteService(FavoriteRepository favoriteRepository, ProductRepository productRepository) {
        this.favoriteRepository = favoriteRepository;
        this.productRepository = productRepository;
    }

    public List<FavoriteDTO> getFavoritesByBuyerId(Long buyerId) {
        return favoriteRepository.findByBuyerId(buyerId).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public void addToFavorite(Long buyerId, Long productId) {
        log.info("Adding product {} to favorites for buyer {}", productId, buyerId);
        
        if (favoriteRepository.findByBuyerIdAndProduct_ProductId(buyerId, productId).isPresent()) {
            return; // Already in favorites
        }

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        Favorite favorite = new Favorite();
        favorite.setBuyerId(buyerId);
        favorite.setProduct(product);

        favoriteRepository.save(favorite);
    }

    @Transactional
    public void removeFromFavorite(Long buyerId, Long productId) {
        log.info("Removing product {} from favorites for buyer {}", productId, buyerId);
        favoriteRepository.deleteByBuyerIdAndProduct_ProductId(buyerId, productId);
    }

    public FavoriteDTO mapToDTO(Favorite favorite) {
        FavoriteDTO dto = new FavoriteDTO();
        dto.setFavoriteId(favorite.getFavoriteId());
        dto.setBuyerId(favorite.getBuyerId());
        dto.setProductId(favorite.getProduct().getProductId());
        dto.setAddedAt(favorite.getAddedAt());
        
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(favorite.getProduct().getProductId());
        productDTO.setName(favorite.getProduct().getName());
        productDTO.setSellingPrice(favorite.getProduct().getSellingPrice());
        productDTO.setImageUrl(favorite.getProduct().getImageUrl());
        dto.setProductDetails(productDTO);
        
        return dto;
    }
}
