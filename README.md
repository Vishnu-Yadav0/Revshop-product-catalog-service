![Banner](https://raw.githubusercontent.com/Vishnu-Yadav0/Revshop-product-catalog-service/main/banner.png)

# 🛍️ RevShop — Product Catalog Service

The core service responsible for managing the product lifecycle, including browsing, searching, categorizing, and managing discounts and reviews/ratings.

[![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square&logo=openjdk)](https://openjdk.org/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?style=flat-square&logo=springboot)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-Database-blue?style=flat-square&logo=mysql)](https://www.mysql.com/)
[![Docker](https://img.shields.io/badge/Docker-Containerized-blue?style=flat-square&logo=docker)](https://www.docker.com/)

---

## Key Features

- **Product Management:** Full CRUD operations for products (Sellers only).
- **Search & Filtering:** Keyword-based and category-based search for Buyers.
- **Dynamic Pricing:** Management of discounts and promotional prices.
- **Customer Feedback:** Integration for product reviews and ratings.
- **Microservices Ready:** Built with Spring Cloud, registers with Eureka.

## Tech Stack

| Layer | Tech |
|---|---|
| Core | Spring Boot 3, Java 17 |
| Database | MySQL |
| Communication | OpenFeign |
| Discovery | Netflix Eureka Client |
| Observability | Spring Boot Actuator, Zipkin |
| Container | Docker |

## Deployment

To run this service independently:
```bash
./mvnw clean install
./mvnw spring-boot:run
```

---

## Part of RevShop Microservices Ecosystem

- 🌐 [Revshop-frontend](https://github.com/Vishnu-Yadav0/Revshop-frontend)
- ⚙️ [Revshop-api-gateway](https://github.com/Vishnu-Yadav0/Revshop-api-gateway)
- 👤 [Revshop-user-service](https://github.com/Vishnu-Yadav0/Revshop-user-service)
- 📦 [Revshop-inventory-service](https://github.com/Vishnu-Yadav0/Revshop-inventory-service)
- 📋 [Revshop-order-sales-service](https://github.com/Vishnu-Yadav0/Revshop-order-sales-service)
- 💳 [Revshop-payment-service](https://github.com/Vishnu-Yadav0/Revshop-payment-service)
- 🔔 [Revshop-notification-service](https://github.com/Vishnu-Yadav0/Revshop-notification-service)
- 🚚 [Revshop-shipping-service](https://github.com/Vishnu-Yadav0/Revshop-shipping-service)
- 🤖 [Revshop-ai-chat-service](https://github.com/Vishnu-Yadav0/Revshop-ai-chat-service)

