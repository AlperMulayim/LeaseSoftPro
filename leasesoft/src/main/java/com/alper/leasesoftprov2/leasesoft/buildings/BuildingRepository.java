package com.alper.leasesoftprov2.leasesoft.buildings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository  extends JpaRepository<Building,Integer> {
}