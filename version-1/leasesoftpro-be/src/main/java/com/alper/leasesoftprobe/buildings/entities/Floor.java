package com.alper.leasesoftprobe.buildings.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "lesapro_floors")
@Data
public class Floor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private  Integer id;

    @Column(name = "floor_number")
    private Integer floorNum;

    @Column(name = "total_unit_per_floor")
    private Integer totalUnit;

    @JsonIgnore
    @Column(name = "building_id")
    private Integer buildingId;

}
