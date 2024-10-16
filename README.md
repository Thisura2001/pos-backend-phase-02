# Point of Sale Backend (Phase 02)

## Overview

The Point of Sale (POS) Backend is a comprehensive solution designed for managing customers, products, orders, and inventory in a retail environment. It provides a robust set of RESTful APIs, enabling functionalities such as creating orders, maintaining customer records, and tracking inventory.

Built with Spring Boot and MySQL, the system adheres to best practices for REST API development, ensuring scalability, performance, and security for high-traffic and data-intensive operations.

## Features

- **Customer Management**: Ability to create, update, delete, and retrieve customer details.
- **Items Management**: Add, update, delete, and fetch Item details for efficient inventory management.
- **Order Processing**: Place new orders, view past order history, and manage order specifics.
- **Inventory Management**: Monitor and manage stock levels, set reorder points, and update product pricing.
- **CRUD Functionality**: Full support for Create, Read, Update, and Delete operations across all entities.
- **DTOs & Entities**: Separates Data Transfer Objects (DTOs) for communication between client and server and entities for database management.
  
## Technologies Used

- **Framework**: Spring Boot
- **Database**: MySQL
- **ORM**: Hibernate (JPA)
- **API Documentation**: Swagger/OpenAPI (optional)
- **Build Tool**: Maven

## Prerequisites

- **Java**: 11 or higher
- **Maven**: 3.6 or later
- **MySQL**: 8.0 or higher

## Getting Started

To get started with the POS Backend, ensure that the prerequisites are installed. Clone the repository, set up the database, and run the application through Maven.

```bash
# Clone the repository
https://github.com/Thisura2001/pos-backend-phase-02.git

# Navigate to the project directory
cd pos-backend

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

## Database Setup

1. Ensure MySQL is running.
2. Create a database with the following command:

```sql
CREATE DATABASE pos;
```

3. Configure the MySQL credentials in the `application.properties` file:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/pos
spring.datasource.username=root
spring.datasource.password=your-password
```

## API Endpoints

Once the application is running, the following API operations will be available:

- **Customer API**: `/api/v1/customers`
  - GET, POST, PUT, DELETE operations for managing customer details.
  
- **Items API**: `/api/v1/items`
  - Manage product details such as name, price, and stock levels.
  
- **Order API**: `/api/v1/orders`
  - Place orders, retrieve order history, and update order details.

Optional: For detailed API documentation, visit the Swagger UI page at `/swagger-ui.html` after running the application.

## License

This project is licensed under the MIT License - see the LICENSE file for details.
