# 🧾 Account Microservice — Spring Boot REST API

⚠️ **Status: In Progress**
> This project is currently under development. Hopefully I can finish it soon :)

---

## 🎯 Project Intent

The intent of this microservice is to **handle account-related operations** for enterprise applications, such as retrieving savings and checking accounts for a given user. It is designed to integrate seamlessly with a centralized OAuth2 Authorization Server, allowing this service to focus purely on **business logic** while delegating authentication and authorization.

This service acts as a secure, modular backend for account data, exposing RESTful endpoints and enforcing scope-based access control using JWTs issued by the Auth Service. It is built with scalability, maintainability, and clean architecture in mind.

The overall design and flow are intended to **mimic a real-world enterprise scenario**, where authentication is centralized, services are decoupled, and account data is accessed securely by authorized clients.

## 🚀 Features

- RESTful endpoints for:
    - `GET /api/v1/accounts?userId=...` — Retrieve all accounts for a user
    - `GET /api/v1/accounts/{userId}/savings` — Retrieve savings accounts
    - `GET /api/v1/accounts/{userId}/checking` — Retrieve checking accounts
    - `POST /api/v1/accounts` — (In progress) Add new accounts
- JWT-based authentication via Spring Security Resource Server
- Scope-based access control (`SCOPE_read`, `SCOPE_write`)
- Custom exception handling with structured error responses
- Modular DTOs and response wrappers
- Logging and monitoring hooks (Datadog, Splunk-ready)
- Integration-ready with Apigee, Kafka, and Salesforce

---

## 🧱 Tech Stack

- Java 17
- Spring Boot 3.5.6
- Spring Security (Resource Server)
- Spring Data JPA + Hibernate
- H2
- Maven
- OAuth2 (JWT validation via JWKS)

---

## 🛠️ Getting Started

### Prerequisites

- Java 17+
- Maven 3.8+
- A running instance of the Auth Service (OAuth2 Authorization Server)
- PostgreSQL or H2 (for local development)

### 1. Clone the project

```bash
git clone https://github.com/your-org/account-service.git
cd account-service