package com.revshop.catalogservice.controller;

import com.revshop.catalogservice.dto.ApiResponse;
import com.revshop.catalogservice.dto.FavoriteDTO;
import com.revshop.catalogservice.service.FavoriteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {

    private final FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @PostMapping("/{buyerId}/{productId}")
    public ResponseEntity<ApiResponse<Void>> add(@PathVariable Long buyerId, @PathVariable Long productId) {
        favoriteService.addToFavorite(buyerId, productId);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Product added to favorites successfully", null));
    }

    @DeleteMapping("/{buyerId}/{productId}")
    public ResponseEntity<ApiResponse<Void>> remove(@PathVariable Long buyerId, @PathVariable Long productId) {
        favoriteService.removeFromFavorite(buyerId, productId);
        return ResponseEntity.ok(new ApiResponse<>("Product removed from favorites successfully", null));
    }

    @GetMapping("/{buyerId}")
    public ResponseEntity<ApiResponse<List<FavoriteDTO>>> getFavorites(@PathVariable Long buyerId) {
        return ResponseEntity.ok(new ApiResponse<>("Favorites fetched successfully", favoriteService.getFavoritesByBuyerId(buyerId)));
    }
}
