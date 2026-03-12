package com.example.revshopproductcatalogservice.client;

import com.example.revshopproductcatalogservice.dto.ApiResponse;
import com.example.revshopproductcatalogservice.dto.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service") // Connecting directly via Eureka App Name
public interface UserClient {

    @GetMapping("/api/users/{id}")
    ApiResponse<UserResponse> getUserById(@PathVariable("id") Long id);
}
