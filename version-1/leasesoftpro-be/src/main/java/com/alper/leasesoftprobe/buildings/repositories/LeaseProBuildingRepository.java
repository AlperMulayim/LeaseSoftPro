package com.alper.leasesoftprobe.buildings.repositories;

import com.alper.leasesoftprobe.buildings.entities.LeasProBuilding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaseProBuildingRepository  extends JpaRepository<LeasProBuilding, Integer> {
    List<LeasProBuilding> findAll();
}
