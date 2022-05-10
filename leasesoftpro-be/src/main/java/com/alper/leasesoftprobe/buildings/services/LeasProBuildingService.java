package com.alper.leasesoftprobe.buildings.services;

import com.alper.leasesoftprobe.buildings.entities.BuildingAdress;
import com.alper.leasesoftprobe.buildings.repositories.BuildingAdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeasProBuildingService {
    @Autowired
    public BuildingAdressRepository adressRepository;

    public List<BuildingAdress> getAllAdress(){
        return  adressRepository.findAll();
    }
}
