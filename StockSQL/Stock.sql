CREATE DATABASE market_stock;

USE market_stock;

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