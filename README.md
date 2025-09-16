# StockFlow: A B2B Inventory Management System

## Overview

**StockFlow** is a comprehensive backend application designed to serve as the core of a B2B inventory management platform. Built with **Spring Boot**, it provides a robust, scalable, and highly available API for managing products, warehouses, suppliers, and inventory levels.

This project was developed as a case study to address and resolve real-world production issues, focusing on **data integrity, transactional consistency, and clean architecture**.

## Key Features

* **RESTful API:** Provides a clean and well-documented API for managing inventory data.
* **Modular, Layered Architecture:** Implements a standard Spring Boot structure with distinct Controller, Service, and Repository layers for clear separation of concerns, ensuring high maintainability and testability.
* **Robust Data Validation:** Utilizes Jakarta Bean Validation to ensure all incoming data meets business requirements, preventing malformed requests from corrupting the database.
* **Transactional Integrity:** Guarantees atomic database operations using Spring's `@Transactional` annotation, preventing partial data saves and ensuring the system remains in a consistent state.
* **Database Schema Design:** Features a flexible and extensible schema to handle complex relationships, including:
    * One-to-many relationship between `Companies` and `Warehouses`.
    * Many-to-many relationships between `Products` and `Warehouses` (via `Inventory`), and `Products` and `Suppliers`.
    * Tracking of sales activity and product types for business intelligence.
* **Global Exception Handling:** Implements a centralized `@ControllerAdvice` to gracefully handle exceptions and provide meaningful, standardized error responses (e.g., `400 Bad Request`, `404 Not Found`, `409 Conflict`).
* **Low-Stock Alerting:** An API endpoint to generate critical low-stock alerts based on current inventory levels, recent sales activity, and product-specific thresholds.

## Technologies Used

* **Backend:** Java 17, Spring Boot 3.2.7
* **Database:** H2 (in-memory for development and file-based for persistence)
* **ORM:** Spring Data JPA, Hibernate
* **Dependency Management:** Maven
* **Utilities:** Lombok (for boilerplate code reduction)

## Database & Initial Data
* The project uses an in-memory H2 database by default. A CommandLineRunner is configured to automatically set up the database schema and populate it with sample data on startup.

## H2 Console:
You can access the H2 console to view the database by navigating to:
```http://localhost:8080/h2-console```
* **JDBC URL:** ```jdbc:h2:mem:stockflowdb```
* **Username:** ```sa```
* **Password:** (leave blank)


## Product & Alerts API

| Endpoint | Method | Description | Request Body (JSON) |
|----------|--------|-------------|----------------------|
| `/api/products` | `POST` | Creates a new product and its initial inventory record in a specified warehouse. | - `name` (string)<br>- `sku` (string)<br>- `price` (number)<br>- `warehouseId` (number)<br>- `initialQuantity` (number) |
| `/api/companies/{companyId}/alerts/low-stock` | `GET` | Retrieves a list of low-stock alerts for all warehouses belonging to a specified company. | None |


## Getting Started

### Prerequisites

* Java Development Kit (JDK) 17 or higher
* Maven 3.6.0 or higher

### Installation

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/kaif0705/Inventory_Management_System
    ```

2.  **Build the project:**
    ```bash
    mvn clean install
    ```

### Running the Application

You can run the application directly from your IDE or using the Maven command: The application will start on port 8080.

```bash
mvn spring-boot:run
