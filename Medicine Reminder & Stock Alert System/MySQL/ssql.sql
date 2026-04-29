CREATE DATABASE medicine_db;
USE medicine_db;

CREATE TABLE medicines (
    medicine_id INT AUTO_INCREMENT PRIMARY KEY,
    medicine_name VARCHAR(100),
    quantity INT,
    expiry_date DATE
);