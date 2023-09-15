package com.alper.leasesoftprov2.leasesoft.buildings.features;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "ldb_features")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BuildingFeature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "feature_name")
    String name;
}
