package com.alper.leasesoftprobe.buildings.services;

import com.alper.leasesoftprobe.buildings.entities.BuildingUnit;
import com.alper.leasesoftprobe.buildings.repositories.BuildingUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingUnitsService {
    @Autowired
    private BuildingUnitRepository repository;

    public List<BuildingUnit> getUnits(){
        return  repository.findAll();
    }
}
