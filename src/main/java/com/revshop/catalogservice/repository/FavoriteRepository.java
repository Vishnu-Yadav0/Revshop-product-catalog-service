package com.revshop.catalogservice.repository;

import com.revshop.catalogservice.model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    List<Favorite> findByBuyerId(Long buyerId);
    Optional<Favorite> findByBuyerIdAndProduct_ProductId(Long buyerId, Long productId);
    void deleteByBuyerIdAndProduct_ProductId(Long buyerId, Long productId);
}
