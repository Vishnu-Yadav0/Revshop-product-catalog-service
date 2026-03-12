package com.revshop.catalogservice.service;

import com.revshop.catalogservice.client.UserClient;
import com.revshop.catalogservice.dto.ApiResponse;
import com.revshop.catalogservice.dto.CategoryDTO;
import com.revshop.catalogservice.dto.ProductDTO;
import com.revshop.catalogservice.dto.ProductVideoDTO;
import com.revshop.catalogservice.dto.UserResponse;
import com.revshop.catalogservice.exception.ResourceNotFoundException;
import com.revshop.catalogservice.model.Category;
import com.revshop.catalogservice.model.Product;
import com.revshop.catalogservice.model.ProductVideo;
import com.revshop.catalogservice.repository.CategoryRepository;
import com.revshop.catalogservice.repository.ProductRepository;
import com.revshop.catalogservice.repository.ProductVideoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductVideoRepository productVideoRepository;
    private final UserClient userClient;

    public ProductService(ProductRepository productRepository,
                          CategoryRepository categoryRepository,
                          ProductVideoRepository productVideoRepository,
                          UserClient userClient) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.productVideoRepository = productVideoRepository;
        this.userClient = userClient;
    }

    // ===================== Read Methods =====================

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public Page<ProductDTO> getAllProductsPaged(Pageable pageable) {
        return productRepository.findAll(pageable).map(this::mapToDTO);
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

    public Page<ProductDTO> getProductsBySeller(Long sellerId, Pageable pageable) {
        return productRepository.findBySellerId(sellerId, pageable).map(this::mapToDTO);
    }

    public List<ProductDTO> getProductsBySeller(Long sellerId) {
        return productRepository.findBySellerId(sellerId).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // ===================== Search & Filter =====================

    public Page<ProductDTO> searchProducts(String keyword, Pageable pageable) {
        return productRepository.searchByKeyword(keyword, pageable).map(this::mapToDTO);
    }

    public Page<ProductDTO> filterProducts(String keyword, BigDecimal minPrice, BigDecimal maxPrice,
                                           Long categoryId, Pageable pageable) {
        return productRepository.filterProducts(keyword, categoryId, minPrice, maxPrice, pageable)
                .map(this::mapToDTO);
    }

    // ===================== CRUD =====================

    @Transactional
    public ProductDTO createProduct(ProductDTO dto) {
        log.info("Creating product name={}", dto.getName());
        Product product = new Product();
        applyDtoToProduct(dto, product);
        return mapToDTO(productRepository.save(product));
    }

    @Transactional
    public ProductDTO updateProduct(Long id, ProductDTO dto) {
        log.info("Updating product id={}", id);
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
        applyDtoToProduct(dto, product);
        return mapToDTO(productRepository.save(product));
    }

    @Transactional
    public void deleteProduct(Long id) {
        log.info("Deleting product id={}", id);
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
        productRepository.delete(product);
    }

    @Transactional
    public ProductDTO toggleActive(Long id) {
        log.info("Toggling active status for product id={}", id);
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
        product.setIsActive(!product.getIsActive());
        return mapToDTO(productRepository.save(product));
    }

    // ===================== Similar & Compare =====================

    public List<ProductDTO> getSimilarProducts(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + productId));
        if (product.getCategory() == null) return List.of();
        return productRepository
                .findByCategory_CategoryIdAndProductIdNotAndIsActiveTrue(
                        product.getCategory().getCategoryId(), productId)
                .stream()
                .limit(8)
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<ProductDTO> getComparisonProducts(List<Long> ids) {
        return productRepository.findAllById(ids).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // ===================== Videos =====================

    public List<ProductVideoDTO> getProductVideos(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + productId));
        return product.getProductVideos().stream().map(v -> {
            ProductVideoDTO vDto = new ProductVideoDTO();
            vDto.setVideoId(v.getVideoId());
            vDto.setVideoUrl(v.getVideoUrl());
            vDto.setVideoType(v.getVideoType());
            return vDto;
        }).collect(Collectors.toList());
    }

    @Transactional
    public ProductVideoDTO addProductVideo(Long productId, String videoUrl, String videoType) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + productId));
        ProductVideo video = new ProductVideo(product, videoUrl, videoType);
        video = productVideoRepository.save(video);
        ProductVideoDTO vDto = new ProductVideoDTO();
        vDto.setVideoId(video.getVideoId());
        vDto.setVideoUrl(video.getVideoUrl());
        vDto.setVideoType(video.getVideoType());
        return vDto;
    }

    // ===================== Helpers =====================

    private void applyDtoToProduct(ProductDTO dto, Product product) {
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setMrp(dto.getMrp());
        product.setSellingPrice(dto.getSellingPrice());
        product.setStockQuantity(dto.getStockQuantity());
        product.setThresholdQuantity(dto.getThresholdQuantity());
        product.setIsActive(dto.getIsActive() != null ? dto.getIsActive() : true);
        product.setImageUrl(dto.getImageUrl());
        product.setAdditionalImages(dto.getAdditionalImages());
        product.setAttributes(dto.getAttributes());
        if (dto.getSellerId() != null) {
            product.setSellerId(dto.getSellerId());
        }
        if (dto.getCategoryId() != null) {
            Category category = categoryRepository.findById(dto.getCategoryId())
                    .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + dto.getCategoryId()));
            product.setCategory(category);
        }
    }

    public ProductDTO mapToDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setProductId(product.getProductId());
        dto.setSellerId(product.getSellerId());

        try {
            ApiResponse<UserResponse> userResponse = userClient.getUserById(product.getSellerId());
            if (userResponse != null && userResponse.getData() != null) {
                dto.setSellerDetails(userResponse.getData());
            }
        } catch (Exception e) {
            log.debug("Could not fetch seller details for sellerId={}: {}", product.getSellerId(), e.getMessage());
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
