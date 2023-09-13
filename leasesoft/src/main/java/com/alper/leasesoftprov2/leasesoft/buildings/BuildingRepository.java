package com.alper.leasesoftprov2.leasesoft.buildings;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingRepository  extends JpaRepository<Building,Integer> {
    List<Building> findAllByBedrooms(Integer bedrooms);
    List<Building> findAll(@Nullable Specification<Building> specification);
}
