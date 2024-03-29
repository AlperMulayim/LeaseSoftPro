CREATE TABLE lesapro_building_adress(
    id INT NOT NULL AUTO_INCREMENT,
    street VARCHAR(100),
    city VARCHAR(100),
    building_number INT,
    block_number INT,
    site_name VARCHAR(100),
    PRIMARY KEY(id)
);

CREATE TABLE lesapro_reports(
    id INT NOT NULL AUTO_INCREMENT,
    report_id BINARY(16),
    report_date DATE,
    user_name VARCHAR(200),
    report_data VARCHAR(2000) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE lesapro_vip_operations(
    id INT NOT NULL AUTO_INCREMENT,
    operation_id VARCHAR(4),
    duration INTEGER,
    price DOUBLE,
    operation_description VARCHAR(300),
    operation_type VARCHAR(20),
    operation_name VARCHAR(100),
    PRIMARY KEY(id)
);

CREATE TABLE lesapro_services_units(
    id  INT AUTO_INCREMENT,
    unit_id INT,
    service_id INT,
    PRIMARY KEY(id),
    FOREIGN KEY(unit_id) REFERENCES lesapro_units(id),
    FOREIGN KEY(service_id)  REFERENCES lesapro_vip_operations(id)
);

CREATE TABLE lesapro_buildings(
    id INT NOT NULL AUTO_INCREMENT,
    building_name VARCHAR(100) NOT NULL,
    standart_price_permonth DOUBLE,
    fee_permonth DOUBLE,
    init_date DATE,
    adress_id INT,

    PRIMARY KEY(id),
    FOREIGN KEY(adress_id) REFERENCES lesapro_building_adress(id)
);

CREATE TABLE lesapro_contacts(
    id INT NOT NULL AUTO_INCREMENT,
    user_uid BINARY(16),
    username VARCHAR(110) NOT NULL,
    surname VARCHAR(150) NOT NULL,
    phone_number VARCHAR(30) NOT NULL,
    adress VARCHAR(300),
    company VARCHAR(50),
    email VARCHAR(100),

    PRIMARY KEY(id)
);

CREATE TABLE lesapro_offers(
    id INT NOT NULL AUTO_INCREMENT,
    offer_uid VARCHAR(50),
    contact_id INT,
    unit_id INT,
    offer_status VARCHAR(30),
    offer_date DATE,
    offer_end_date DATE,
    discount_rate DOUBLE,
    commission_price DOUBLE,

    PRIMARY KEY(id),
    FOREIGN KEY (contact_id) REFERENCES lesapro_contacts(id),
    FOREIGN KEY(unit_id) REFERENCES lesapro_units(id)
);

CREATE TABLE lesapro_floors(
    id INT NOT NULL AUTO_INCREMENT,
    total_unit_per_floor INT,
    building_id INT,
    floor_number INT NOT NULL,
    
    PRIMARY KEY(id),
    FOREIGN KEY(building_id) REFERENCES lesapro_buildings(id)
);

CREATE TABLE lesapro_units(
    id INT NOT NULL AUTO_INCREMENT,
    building_id INT,
    floor_id INT,
    unit_type VARCHAR(30),
    area DOUBLE,
    price DOUBLE,
    price_period VARCHAR(30),

    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS users (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(1000) NOT NULL,
  `enabled` INT NOT NULL,
  PRIMARY KEY (`id`)
  );


CREATE TABLE IF NOT EXISTS authorities (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `authority` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
  );


INSERT IGNORE INTO authorities VALUES (NULL, 'john', 'write'); 
INSERT IGNORE INTO users VALUES (NULL, 'john', '12345', '1');



INSERT INTO lesapro_building_adress(
    street,
    city
) VALUES(
    "ABC STREET",
    "MYCITYAWASOME"
);

INSERT INTO lesapro_buildings (
    building_name,
    adress_id,
    fee_permonth,
    standart_price_permonth,
    init_date
)
VALUES(
    "LESA RESIDENCE",
    1,
    200.0,
    1000.0, 
    curdate()
 );

INSERT INTO lesapro_floors(
    total_unit_per_floor,
    building_id,
    floor_number
) VALUES(
    4,1,2
);



 SELECT * FROM lesapro_buildings;
 SELECT * FROM lesapro_building_adress;
 SELECT * FROM lesapro_floors;

DROP TABLE lesapro_buildings;
DROP TABLE lesapro_building_adress;
DROP TABLE lesapro_floors;
