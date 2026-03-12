package com.revshop.catalogservice.repository;

import com.revshop.catalogservice.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory_CategoryId(Long categoryId);
    List<Product> findBySellerId(Long sellerId);

    // Paginated versions
    Page<Product> findAll(Pageable pageable);
    Page<Product> findBySellerId(Long sellerId, Pageable pageable);
    Page<Product> findByCategory_CategoryId(Long categoryId, Pageable pageable);

    // Keyword search
    @Query("SELECT p FROM Product p WHERE " +
           "LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    Page<Product> searchByKeyword(@Param("keyword") String keyword, Pageable pageable);

    // Filter with optional params
    @Query("SELECT p FROM Product p WHERE " +
           "(:keyword IS NULL OR LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%'))) AND " +
           "(:categoryId IS NULL OR p.category.categoryId = :categoryId) AND " +
           "(:minPrice IS NULL OR p.sellingPrice >= :minPrice) AND " +
           "(:maxPrice IS NULL OR p.sellingPrice <= :maxPrice) AND " +
           "p.isActive = true")
    Page<Product> filterProducts(
            @Param("keyword") String keyword,
            @Param("categoryId") Long categoryId,
            @Param("minPrice") BigDecimal minPrice,
            @Param("maxPrice") BigDecimal maxPrice,
            Pageable pageable);

    // Similar products (same category, different product)
    List<Product> findByCategory_CategoryIdAndProductIdNotAndIsActiveTrue(Long categoryId, Long excludeId);
}
