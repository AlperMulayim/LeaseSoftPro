package com.alper.leasesoftprobe.buildings.entities;

import lombok.Data;
import org.hibernate.annotations.LazyToOne;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "lesapro_buildings")
@Data
public class LeasProBuilding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "building_name")
    private  String name;

    @Column(name = "standart_price_permonth")
    private Double monthlyPrice;

    @Column(name = "fee_permonth")
    private Double monthlyFee;

    @Column(name = "init_date")
    private Date initDate;

    @OneToOne
    @JoinColumn(name = "adress_id")
    BuildingAdress adress;

    @OneToMany(mappedBy = "buildingId", targetEntity = Floor.class)
    List<Floor> floors;
}
