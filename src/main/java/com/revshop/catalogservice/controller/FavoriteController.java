package com.revshop.catalogservice.controller;

import com.revshop.catalogservice.dto.ApiResponse;
import com.revshop.catalogservice.dto.FavoriteDTO;
import com.revshop.catalogservice.service.FavoriteService;
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

    @GetMapping("/buyer/{buyerId}")
    public ResponseEntity<ApiResponse<List<FavoriteDTO>>> getFavoritesByBuyerId(@PathVariable Long buyerId) {
        return ResponseEntity.ok(new ApiResponse<>("Favorites fetched successfully", favoriteService.getFavoritesByBuyerId(buyerId)));
    }
}
