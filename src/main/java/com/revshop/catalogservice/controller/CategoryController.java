package com.revshop.catalogservice.controller;

import com.revshop.catalogservice.dto.ApiResponse;
import com.revshop.catalogservice.dto.CategoryDTO;
import com.revshop.catalogservice.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CategoryDTO>>> getAllCategories() {
        return ResponseEntity.ok(new ApiResponse<>("Categories fetched successfully", categoryService.getAllCategories()));
    }

    @GetMapping("/root")
    public ResponseEntity<ApiResponse<List<CategoryDTO>>> getRootCategories() {
        return ResponseEntity.ok(new ApiResponse<>("Root categories fetched successfully", categoryService.getRootCategories()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CategoryDTO>> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(new ApiResponse<>("Category fetched successfully", categoryService.getCategoryById(id)));
    }
}
