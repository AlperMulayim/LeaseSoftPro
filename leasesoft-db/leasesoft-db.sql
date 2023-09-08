-- Active: 1664392447753@@127.0.0.1@3306
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

