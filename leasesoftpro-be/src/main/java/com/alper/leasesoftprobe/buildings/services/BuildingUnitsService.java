package com.alper.leasesoftprobe.buildings.services;

import com.alper.leasesoftprobe.buildings.entities.BuildingUnit;
import com.alper.leasesoftprobe.buildings.enums.UnitTypes;
import com.alper.leasesoftprobe.buildings.repositories.BuildingUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BuildingUnitsService {
    @Autowired
    private BuildingUnitRepository repository;

    public List<BuildingUnit> getUnits(){
        return  repository.findAll();
    }
    public Optional<BuildingUnit> getUnit(Integer id){
        return  repository.findById(id);
    }
    public List<BuildingUnit> getUnits(UnitTypes unitType){
        return  repository.findByUnitType(unitType);
    }
}
