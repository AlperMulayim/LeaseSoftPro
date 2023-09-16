-- Active: 1694183684972@@127.0.0.1@3306@leasesoftv2

CREATE DATABASE IF NOT EXISTS leasesoftv2;
USE leasesoftv2;


CREATE TABLE  ldb_client(  
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(255),
    surname VARCHAR(255),
    email VARCHAR(255),
    phone VARCHAR(255),
    create_date DATE
);

CREATE TABLE  ldb_employees(  
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(255),
    surname VARCHAR(255),
    email VARCHAR(255),
    phone VARCHAR(255),
    start_date DATE,
    end_date DATE,
    job_title VARCHAR(255)
);


CREATE TABLE ldb_buildings(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    block_name VARCHAR(255),
    city VARCHAR(255),
    building_size DOUBLE,
    num_bedrooms INT,
    num_bathrooms INT,
    num_carspace INT,
    property_type ENUM('B_ROOM','B_OFFICE','B_APART'),
    lat DECIMAL(10,7),
    lot DECIMAL(10,7),
    address VARCHAR(400)
);

CREATE TABLE ldb_listings(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    building_id INT,
    listing_code VARCHAR(255),
    listing_status ENUM('ACTIVE','PASSIVE','CONTRACT','COMPLETE'),
    listing_type ENUM('MONTHLY','YEARLY','DAILY'),
    price DOUBLE,
    price_unit VARCHAR(4),
    create_date DATETIME,
    end_date DATETIME,
    update_date DATETIME,
    FOREIGN KEY(building_id) REFERENCES ldb_buildings(id)
)


CREATE TABLE ldb_features(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    feature_name VARCHAR(500)
);

CREATE TABLE ldb_building_features(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    feature_id INT,
    building_id INT,
    FOREIGN KEY(feature_id) REFERENCES ldb_features(id),
    FOREIGN KEY(building_id) REFERENCES ldb_buildings(id)
)