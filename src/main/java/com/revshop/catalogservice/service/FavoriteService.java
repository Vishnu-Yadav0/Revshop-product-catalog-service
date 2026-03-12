package com.revshop.catalogservice.service;

import com.revshop.catalogservice.dto.FavoriteDTO;
import com.revshop.catalogservice.dto.ProductDTO;
import com.revshop.catalogservice.model.Favorite;
import com.revshop.catalogservice.repository.FavoriteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;

    public FavoriteService(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }

    public List<FavoriteDTO> getFavoritesByBuyerId(Long buyerId) {
        return favoriteRepository.findByBuyerId(buyerId).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private FavoriteDTO mapToDTO(Favorite favorite) {
        FavoriteDTO dto = new FavoriteDTO();
        dto.setFavoriteId(favorite.getFavoriteId());
        dto.setBuyerId(favorite.getBuyerId());
        dto.setProductId(favorite.getProduct().getProductId());
        dto.setAddedAt(favorite.getAddedAt());
        
        // Basic mapping for product summary
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(favorite.getProduct().getProductId());
        productDTO.setName(favorite.getProduct().getName());
        productDTO.setSellingPrice(favorite.getProduct().getSellingPrice());
        productDTO.setImageUrl(favorite.getProduct().getImageUrl());
        dto.setProductDetails(productDTO);
        
        return dto;
    }
}
