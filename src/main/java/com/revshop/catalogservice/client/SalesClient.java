package com.revshop.catalogservice.client;

import com.revshop.catalogservice.dto.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "sales-service")
public interface SalesClient {

    @GetMapping("/api/orders/check-purchase")
    ApiResponse<Boolean> checkPurchase(
            @RequestParam("userId") Long userId,
            @RequestParam("productId") Long productId);
}
