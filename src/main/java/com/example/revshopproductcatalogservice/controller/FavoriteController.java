package com.example.revshopproductcatalogservice.controller;

import com.example.revshopproductcatalogservice.dto.ApiResponse;
import com.example.revshopproductcatalogservice.dto.FavoriteDTO;
import com.example.revshopproductcatalogservice.service.FavoriteService;
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
