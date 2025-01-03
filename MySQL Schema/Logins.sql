-- Use the database
USE usms;

-- Table for storing Admins details
CREATE TABLE admins (
    id         INT             AUTO_INCREMENT  PRIMARY KEY,
    username   VARCHAR(6)      NOT NULL        UNIQUE,
    email      VARCHAR(100)    NOT NULL        UNIQUE,
    password   VARCHAR(10)     NOT NULL,
    CHECK (
        LENGTH(username) BETWEEN 1 AND 6 AND
        username = BINARY LOWER(username) AND
        username REGEXP '^[a-z]+$'
        ),
    CHECK (
        (email LIKE '%@gmail.com' OR email LIKE '%@nibm.lk') AND
        email = BINARY LOWER(email)
        ),
    CHECK (
        LENGTH(password) BETWEEN 5 AND 10 AND
        password REGEXP '[a-z]' AND
        password REGEXP '[0-9]' AND
        password REGEXP '^[a-z0-9]+$'
        )
);

-- Table for storing Users details
CREATE TABLE users (
    id          INT             AUTO_INCREMENT  PRIMARY KEY,
    username    VARCHAR(6)      NOT NULL        UNIQUE,
    email       VARCHAR(100)    NOT NULL        UNIQUE,
    password    VARCHAR(10)     NOT NULL,
    CHECK (
        LENGTH(username) BETWEEN 1 AND 6 AND
        username = BINARY LOWER(username) AND
        username REGEXP '^[a-z]+$'
        ),
    CHECK (
        (email LIKE '%@gmail.com' OR email LIKE '%@nibm.lk') AND
        email = BINARY LOWER(email)
        ),
    CHECK (
        LENGTH(password) BETWEEN 5 AND 10 AND
        password REGEXP '[a-z]' AND
        password REGEXP '[0-9]' AND
        password REGEXP '^[a-z0-9]+$'
        )
);

-- Insert a test admin
INSERT INTO admins (username, email, password)
VALUES ('admin', 'admin@gmail.com', 'add123');

-- Insert a test user
INSERT INTO users (username, email, password)
VALUES ('sudil', 'sudil@gmail.com', 'sss111');