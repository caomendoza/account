# Account Service

This microservice manages user accounts in a secure, scalable banking system. It exposes RESTful endpoints for retrieving and managing account data, and integrates with Spring Security to enforce JWT-based access control.

## 🔐 Features

- REST API for account data (GET, POST, etc.)
- JWT authentication via Spring Resource Server
- Scope-based access control (`SCOPE_read`, `SCOPE_write`)
- Realistic account modeling with lifecycle states
- Currency and account type support (`PHP`, `USD`, `CA`, `SA`)
- Primary account flag for business logic
- Seed data for testing and simulation

## 🚀 Getting Started

### Prerequisites

- Java 17+
- Maven or Gradle
- Spring Boot 3.x
- Running Auth Service with JWKS endpoint

### Run the service

```bash
./mvnw spring-boot:run