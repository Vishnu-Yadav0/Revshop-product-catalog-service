package com.revshop.catalogservice.service;

import com.revshop.catalogservice.client.UserClient;
import com.revshop.catalogservice.dto.ApiResponse;
import com.revshop.catalogservice.dto.ProductDTO;
import com.revshop.catalogservice.dto.UserResponse;
import com.revshop.catalogservice.exception.ResourceNotFoundException;
import com.revshop.catalogservice.model.Product;
import com.revshop.catalogservice.model.Category;
import com.revshop.catalogservice.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private UserClient userClient;

    @InjectMocks
    private ProductService productService;

    private Product product;
    private Category category;

    @BeforeEach
    void setUp() {
        category = new Category();
        category.setCategoryId(1L);
        category.setName("Electronics");

        product = new Product();
        product.setProductId(1L);
        product.setName("Smartphone");
        product.setDescription("High-end smartphone");
        product.setMrp(new BigDecimal("1000.00"));
        product.setSellingPrice(new BigDecimal("900.00"));
        product.setStockQuantity(100);
        product.setThresholdQuantity(10);
        product.setSellerId(10L);
        product.setCategory(category);
        product.setIsActive(true);
    }

    @Test
    void getAllProducts_shouldReturnList() {
        when(productRepository.findAll()).thenReturn(List.of(product));
        
        List<ProductDTO> results = productService.getAllProducts();

        assertThat(results).hasSize(1);
        assertThat(results.get(0).getName()).isEqualTo("Smartphone");
        verify(productRepository).findAll();
    }

    @Test
    void getProductById_shouldReturnDTO_whenFound() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        
        ApiResponse<UserResponse> userResponse = new ApiResponse<>();
        UserResponse userData = new UserResponse();
        userData.setUserId(10L);
        userData.setEmail("seller@example.com");
        userResponse.setData(userData);
        
        when(userClient.getUserById(10L)).thenReturn(userResponse);

        ProductDTO result = productService.getProductById(1L);

        assertThat(result).isNotNull();
        assertThat(result.getProductId()).isEqualTo(1L);
        assertThat(result.getSellerDetails()).isNotNull();
        assertThat(result.getSellerDetails().getEmail()).isEqualTo("seller@example.com");
    }

    @Test
    void getProductById_shouldThrowException_whenNotFound() {
        when(productRepository.findById(99L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> productService.getProductById(99L))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessageContaining("Product not found");
    }

    @Test
    void getProductsByCategory_shouldReturnList() {
        when(productRepository.findByCategory_CategoryId(1L)).thenReturn(List.of(product));

        List<ProductDTO> results = productService.getProductsByCategory(1L);

        assertThat(results).hasSize(1);
        assertThat(results.get(0).getCategoryId()).isEqualTo(1L);
    }

    @Test
    void getProductsBySeller_shouldReturnList() {
        when(productRepository.findBySellerId(10L)).thenReturn(List.of(product));

        List<ProductDTO> results = productService.getProductsBySeller(10L);

        assertThat(results).hasSize(1);
        assertThat(results.get(0).getSellerId()).isEqualTo(10L);
    }
}
