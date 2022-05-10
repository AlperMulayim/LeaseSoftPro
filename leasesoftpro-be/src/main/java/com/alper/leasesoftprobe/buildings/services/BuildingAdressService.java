package com.alper.leasesoftprobe.buildings.services;

import com.alper.leasesoftprobe.buildings.entities.BuildingAdress;
import com.alper.leasesoftprobe.buildings.entities.LeasProBuilding;
import com.alper.leasesoftprobe.buildings.repositories.BuildingAdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuildingAdressService {
    @Autowired
    private BuildingAdressRepository repository;

    @Autowired
    private LeasProBuildingService buildingService;

    public BuildingAdress save(BuildingAdress adress) throws  Exception{
        Optional<LeasProBuilding> building = buildingService.getBuilding(adress.getBuildingNumber());
        Optional.ofNullable(building.get()).orElseThrow(RuntimeException::new);
        building.ifPresent(b->b.setAdress(adress));
        return  repository.save(adress);
    }
}
