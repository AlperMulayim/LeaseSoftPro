package com.alper.leasesoftprobe.buildings.entities;

import com.alper.leasesoftprobe.buildings.enums.PricePeriod;
import com.alper.leasesoftprobe.buildings.enums.UnitTypes;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "lesapro_units")
@Data
public class BuildingUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;

    @Column(name = "building_id")
    private Integer buildingId;

    @Column(name = "floorId")
    private Integer floorId;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "unit_type")
    private UnitTypes unitType;

    @Column(name = "area")
    private Double area;

    @Column(name = "price")
    private Double price;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "price_period")
    private PricePeriod pricePeriod;
}
