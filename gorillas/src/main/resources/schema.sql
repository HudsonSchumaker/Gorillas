CREATE TABLE IF NOT EXISTS USER(
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(64),
    last_name VARCHAR(64),
    user_name VARCHAR(32),
    password VARCHAR(16),
    email VARCHAR(64)
);