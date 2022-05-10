package com.alper.leasesoftprobe.buildings.services;

import com.alper.leasesoftprobe.buildings.entities.BuildingAdress;
import com.alper.leasesoftprobe.buildings.entities.LeasProBuilding;
import com.alper.leasesoftprobe.buildings.repositories.BuildingAdressRepository;
import com.alper.leasesoftprobe.buildings.repositories.LeaseProBuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeasProBuildingService {
    @Autowired
    public BuildingAdressRepository adressRepository;

    @Autowired
    public LeaseProBuildingRepository buildingRepository;

    public List<BuildingAdress> getAllAdress(){
        return  adressRepository.findAll();
    }

    public List<LeasProBuilding> getBuildings(){
        return buildingRepository.findAll();
    }
}
