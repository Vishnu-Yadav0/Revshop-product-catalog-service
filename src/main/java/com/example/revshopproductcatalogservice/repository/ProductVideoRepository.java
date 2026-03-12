package com.example.revshopproductcatalogservice.repository;

import com.example.revshopproductcatalogservice.model.ProductVideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductVideoRepository extends JpaRepository<ProductVideo, Long> {
    List<ProductVideo> findByProduct_ProductId(Long productId);
}
