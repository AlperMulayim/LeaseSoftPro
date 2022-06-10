package com.alper.leasesoftprobe.vipservices.entities;

import com.alper.leasesoftprobe.buildings.entities.BuildingUnit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.IdentityHashMap;
import java.util.List;

@Entity
@Table(name="lesapro_vip_operations")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VipOperations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "operation_id")
    private String operationId;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "price")
    private  Double price;

    @Column(name = "operation_type")
    private String type;

    @Column(name = "operation_name")
    private String name;

    @Column(name="operation_description")
    private String  description;

    @ManyToMany
    @JoinTable(
            name = "lesapro_services_units",
            joinColumns = @JoinColumn(name="service_id"),
            inverseJoinColumns = @JoinColumn(name = "unit_id")
    )
    private List<BuildingUnit> units;
}


//    CREATE TABLE lesapro_vip_operations(
//        id INT NOT NULL AUTO_INCREMENT,
//        operationId VARCHAR(4),
//    duration INTEGER,
//    price DOUBLE,
//    operation_description VARCHAR(300),
//    operation_type VARCHAR(20),
//    operation_name VARCHAR(100),
//
//    PRIMARY KEY(id)
//);
