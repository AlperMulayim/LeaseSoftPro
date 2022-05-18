CREATE TABLE lesapro_building_adress(
    id INT NOT NULL AUTO_INCREMENT,
    street VARCHAR(100),
    city VARCHAR(100),
    building_number INT,
    block_number INT,
    site_name VARCHAR(100),
    PRIMARY KEY(id)
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
