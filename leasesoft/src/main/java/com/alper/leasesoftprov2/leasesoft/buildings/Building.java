package com.alper.leasesoftprov2.leasesoft.buildings;

import com.alper.leasesoftprov2.leasesoft.buildings.features.BuildingFeature;
import com.alper.leasesoftprov2.leasesoft.listing.BuildingListing;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "ldb_buildings")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonProperty("name")
    @Column(name = "block_name")
    private String blockName;

    @Column(name = "city")
    private String city;

    @Column(name = "building_size")
    private Double size;

    @JsonProperty("beds")
    @Column(name = "num_bedrooms")
    private Integer bedrooms;

    @JsonProperty("baths")
    @Column(name = "num_bathrooms")
    private Integer bathrooms;

    @Column(name = "num_carspace")
    private Integer carSpaces;

    @Column(name = "property_type", length = 255, columnDefinition = "enum")
    @JsonProperty("type")
    @Enumerated(EnumType.STRING)
    private BuildingType type;

    @Column(name="lat", precision = 10, scale=7)
    private BigDecimal lat;

    @Column(name="lot", precision = 10, scale=7)
    private BigDecimal lot;

    @Column(name = "address")
    private String address;

    @OneToOne
    @JoinColumn(name = "id")
    private BuildingListing listing;

    @ManyToMany
    @JoinTable(
            name = "ldb_building_features",
            joinColumns = @JoinColumn(name = "building_id"),
            inverseJoinColumns = @JoinColumn(name = "feature_id")
    )
    private List<BuildingFeature> features;

}
