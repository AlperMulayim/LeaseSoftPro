package com.alper.leasesoftprobe.buildings.repositories;

import com.alper.leasesoftprobe.buildings.entities.BuildingUnit;
import com.alper.leasesoftprobe.buildings.enums.UnitTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface BuildingUnitRepository extends JpaRepository<BuildingUnit,Integer> {
        List<BuildingUnit> findByUnitType(UnitTypes unitType);
}
