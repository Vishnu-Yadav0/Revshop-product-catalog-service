package com.revshop.catalogservice.controller;

import com.revshop.catalogservice.dto.ApiResponse;
import com.revshop.catalogservice.dto.ProductDTO;
import com.revshop.catalogservice.dto.ProductVideoDTO;
import com.revshop.catalogservice.service.ProductService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    private static final String FETCHED_SUCCESSFULLY = "Products fetched successfully";

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // ===================== CRUD =====================

    @PostMapping
    public ResponseEntity<ApiResponse<ProductDTO>> create(@Valid @RequestBody ProductDTO dto) {
        log.info("POST /api/products");
        ProductDTO saved = productService.createProduct(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Product created successfully", saved));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Page<ProductDTO>>> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "productId") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {
        Sort sort = direction.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        log.info("GET /api/products - page={} size={}", page, size);
        Page<ProductDTO> products = productService.getAllProductsPaged(pageable);
        return ResponseEntity.ok(new ApiResponse<>(FETCHED_SUCCESSFULLY, products));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductDTO>> getById(@PathVariable Long id) {
        log.info("GET /api/products/{}", id);
        return ResponseEntity.ok(new ApiResponse<>("Product fetched successfully", productService.getProductById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductDTO>> update(@PathVariable Long id, @Valid @RequestBody ProductDTO dto) {
        log.info("PUT /api/products/{}", id);
        return ResponseEntity.ok(new ApiResponse<>("Product updated successfully", productService.updateProduct(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> delete(@PathVariable Long id) {
        log.info("DELETE /api/products/{}", id);
        productService.deleteProduct(id);
        return ResponseEntity.ok(new ApiResponse<>("Product deleted successfully", null));
    }

    // ===================== Listing by Seller / Category =====================

    @GetMapping("/seller/{sellerId}")
    public ResponseEntity<ApiResponse<Page<ProductDTO>>> getProductsBySeller(
            @PathVariable Long sellerId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(defaultValue = "productId") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {
        Sort sort = direction.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        log.info("GET /api/products/seller/{} - page={} size={}", sellerId, page, size);
        return ResponseEntity.ok(new ApiResponse<>(FETCHED_SUCCESSFULLY, productService.getProductsBySeller(sellerId, pageable)));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<ApiResponse<List<ProductDTO>>> getProductsByCategory(@PathVariable Long categoryId) {
        log.info("GET /api/products/category/{}", categoryId);
        return ResponseEntity.ok(new ApiResponse<>(FETCHED_SUCCESSFULLY, productService.getProductsByCategory(categoryId)));
    }

    // ===================== Search & Filter =====================

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<Page<ProductDTO>>> search(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "productId") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {
        Sort sort = direction.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        log.info("GET /api/products/search - keyword={}", keyword);
        return ResponseEntity.ok(new ApiResponse<>(FETCHED_SUCCESSFULLY, productService.searchProducts(keyword, pageable)));
    }

    @GetMapping("/filter")
    public ResponseEntity<ApiResponse<Page<ProductDTO>>> filter(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice,
            @RequestParam(required = false) Long categoryId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "productId") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {
        Sort sort = direction.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        log.info("GET /api/products/filter - keyword={} categoryId={}", keyword, categoryId);
        return ResponseEntity.ok(new ApiResponse<>("Filtered products fetched", productService.filterProducts(keyword, minPrice, maxPrice, categoryId, pageable)));
    }

    // ===================== Special Endpoints =====================

    @PatchMapping("/{id}/toggle-active")
    public ResponseEntity<ApiResponse<ProductDTO>> toggleActive(@PathVariable Long id) {
        log.info("PATCH /api/products/{}/toggle-active", id);
        return ResponseEntity.ok(new ApiResponse<>("Product status toggled", productService.toggleActive(id)));
    }

    @GetMapping("/{id}/similar")
    public ResponseEntity<ApiResponse<List<ProductDTO>>> getSimilarProducts(@PathVariable Long id) {
        log.info("GET /api/products/{}/similar", id);
        return ResponseEntity.ok(new ApiResponse<>("Similar products fetched successfully", productService.getSimilarProducts(id)));
    }

    @GetMapping("/compare")
    public ResponseEntity<ApiResponse<List<ProductDTO>>> compareProducts(@RequestParam List<Long> ids) {
        log.info("GET /api/products/compare?ids={}", ids);
        return ResponseEntity.ok(new ApiResponse<>("Comparison products fetched successfully", productService.getComparisonProducts(ids)));
    }

    // ===================== Videos =====================

    @GetMapping("/{id}/videos")
    public ResponseEntity<ApiResponse<List<ProductVideoDTO>>> getProductVideos(@PathVariable Long id) {
        log.info("GET /api/products/{}/videos", id);
        return ResponseEntity.ok(new ApiResponse<>("Product videos fetched successfully", productService.getProductVideos(id)));
    }

    @PostMapping("/{id}/videos")
    public ResponseEntity<ApiResponse<ProductVideoDTO>> addProductVideo(
            @PathVariable Long id,
            @RequestBody Map<String, String> videoData) {
        log.info("POST /api/products/{}/videos", id);
        ProductVideoDTO video = productService.addProductVideo(id, videoData.get("videoUrl"), videoData.get("videoType"));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Video added successfully", video));
    }
}
