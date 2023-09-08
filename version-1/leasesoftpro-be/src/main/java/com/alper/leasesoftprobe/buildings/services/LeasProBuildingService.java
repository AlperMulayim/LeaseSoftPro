package com.alper.leasesoftprobe.buildings.services;

import com.alper.leasesoftprobe.buildings.entities.BuildingAdress;
import com.alper.leasesoftprobe.buildings.entities.LeasProBuilding;
import com.alper.leasesoftprobe.buildings.repositories.BuildingAdressRepository;
import com.alper.leasesoftprobe.buildings.repositories.LeaseProBuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class LeasProBuildingService {
    @Autowired
    public BuildingAdressRepository adressRepository;

    @Autowired
    public LeaseProBuildingRepository buildingRepository;

    public List<BuildingAdress> getAllAdress(Optional<Integer> id){
        if(!id.isPresent()){
            return  adressRepository.findAll();
        }else {
            List<BuildingAdress> adres = new LinkedList<>();
            Optional<BuildingAdress> adress = adressRepository.findById(id.get());
            adress.ifPresent(adres::add);
            return  adres;
        }
    }

    public List<LeasProBuilding> getBuildings(){
        return  buildingRepository.findAll();
    }
    public Optional<LeasProBuilding> getBuilding(Integer id){
        Optional<LeasProBuilding> proBuilding = buildingRepository.findById(id);
        return proBuilding;
    }
    public LeasProBuilding addBuilding(LeasProBuilding building){
        return buildingRepository.save(building);
    }
}
