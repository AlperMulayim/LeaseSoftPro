package com.alper.leasesoftprobe.buildings.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "lesapro_building_adress")
@Data
public class BuildingAdress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name= "building_number")
    private Integer buildingNumber;

    @Column(name = "block_number")
    private Integer blockNumber;

    @Column(name = "site_name")
    private  String siteName;
}
