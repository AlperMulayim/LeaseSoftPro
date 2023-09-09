package com.alper.leasesoftprov2.leasesoft.buildings;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ldb_buildings")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "block_name")
    private String blockName;

    @Column(name = "city")
    private String city;

    @Column(name = "building_size")
    private Double size;

    @Column(name = "num_bedrooms")
    private Integer bedrooms;

    @Column(name = "num_bathrooms")
    private Integer bathrooms;

    @Column(name = "num_carspace")
    private Integer carSpaces;

    @Column(name = "property_type", length = 255, columnDefinition = "enum")
    @JsonProperty("type")
    @Enumerated(EnumType.STRING)
    private BuildingType type;

}
