package com.example.revshopproductcatalogservice.controller;

import com.example.revshopproductcatalogservice.dto.ApiResponse;
import com.example.revshopproductcatalogservice.dto.ProductDTO;
import com.example.revshopproductcatalogservice.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductDTO>>> getAllProducts() {
        return ResponseEntity.ok(new ApiResponse<>("Products fetched successfully", productService.getAllProducts()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductDTO>> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(new ApiResponse<>("Product fetched successfully", productService.getProductById(id)));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<ApiResponse<List<ProductDTO>>> getProductsByCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(new ApiResponse<>("Products by category fetched successfully", productService.getProductsByCategory(categoryId)));
    }

    @GetMapping("/seller/{sellerId}")
    public ResponseEntity<ApiResponse<List<ProductDTO>>> getProductsBySeller(@PathVariable Long sellerId) {
        return ResponseEntity.ok(new ApiResponse<>("Products by seller fetched successfully", productService.getProductsBySeller(sellerId)));
    }
}
