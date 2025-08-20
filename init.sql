CREATE DATABASE IF NOT EXISTS beautyproject;
USE beautyproject;

CREATE TABLE IF NOT EXISTS admin (
   admin_id INT AUTO_INCREMENT PRIMARY KEY,
   admin_email VARCHAR(255) NOT NULL,
   admin_name VARCHAR(255) NOT NULL,
   admin_number VARCHAR(20),
   admin_password VARCHAR(255) NOT NULL
);

INSERT INTO admin (admin_email, admin_name, admin_number, admin_password) VALUES ('admin@example.com', 'Admin User', '1234567890', 'admin123');

