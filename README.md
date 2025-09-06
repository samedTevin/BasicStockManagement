# Stock Management System

A Java-based inventory management system with MySQL database integration. Manage products, categories, and suppliers through an interactive console interface.

## Features

- Complete CRUD operations for Categories, Suppliers, and Products
- Interactive menu-driven console interface
- MySQL database integration with JDBC
- Input validation and error handling
- Proper resource management

## Technologies Used

- **Java SE**: Core programming language and OOP principles
- **MySQL**: Relational database management system
- **JDBC**: Database connectivity and PreparedStatements
- **Exception Handling**: Resource management with try-catch-finally

## Quick Setup

1. **Prerequisites**: Java JDK 8+, MySQL Server, MySQL JDBC Driver

2. **Database Setup**:
   ```sql
   CREATE DATABASE market_stock;
   
   CREATE TABLE category (
       id INT PRIMARY KEY AUTO_INCREMENT,
       category_name VARCHAR(100) NOT NULL
   );
   
   CREATE TABLE supplier (
       id INT PRIMARY KEY AUTO_INCREMENT,
       supplier_name VARCHAR(100) NOT NULL,
       address VARCHAR(255),
       phone_num VARCHAR(20),
       email VARCHAR(100)
   );
   
   CREATE TABLE product (
       id INT PRIMARY KEY AUTO_INCREMENT,
       product_name VARCHAR(100) NOT NULL,
       brand VARCHAR(100),
       country_code VARCHAR(10),
       price DECIMAL(10,2),
       stock_quantity INT
   );
   ```

3. **Configure Database**: Update credentials in `DbHelper.java`
   ```java
   private String userName = "your_username";
   private String password = "your_password";
   ```

4. **Run**: 
   ```bash
   javac *.java
   java Main
   ```

## Project Structure

```
├── Main.java                    # Application entry point
├── Menu.java                    # User interface and navigation
├── Validator.java               # Input validation utilities
├── DbHelper.java               # Database connection management
├── Category.java               # Category model
├── CategoryManager.java        # Category CRUD operations
├── CategoryInputHandler.java   # Category input handling
├── Product.java                # Product model
├── InventoryManager.java       # Product CRUD operations
├── ProductInputHandler.java    # Product input handling
├── Supplier.java               # Supplier model
├── SupplierManager.java        # Supplier CRUD operations
└── SupplierInputHandler.java   # Supplier input handling
```

## Key Features

- Separation of concerns with clean architecture
- SQL injection prevention using PreparedStatements
- Comprehensive input validation
- Proper database connection cleanup

## Author

**Samed Tevin**

---
**Note**: Update database credentials before running. Never commit passwords to version control.
