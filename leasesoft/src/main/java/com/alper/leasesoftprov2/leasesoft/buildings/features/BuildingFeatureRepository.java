package com.alper.leasesoftprov2.leasesoft.buildings.features;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingFeatureRepository extends JpaRepository<BuildingFeature,Integer> {
}
