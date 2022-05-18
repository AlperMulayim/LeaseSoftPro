package com.alper.leasesoftprobe.buildings.repositories;

import com.alper.leasesoftprobe.buildings.entities.BuildingUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BuildingUnitRepository extends JpaRepository<BuildingUnit,Integer> {

}
