package com.alper.leasesoftprobe.buildings.controllers;

import com.alper.leasesoftprobe.buildings.entities.BuildingAdress;
import com.alper.leasesoftprobe.buildings.entities.LeasProBuilding;
import com.alper.leasesoftprobe.buildings.repositories.BuildingAdressRepository;
import com.alper.leasesoftprobe.buildings.services.LeasProBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/buildings")
public class BuildingController {

    @Autowired
    public LeasProBuildingService buildingService;

    @GetMapping("/adress")
    public List<BuildingAdress> getAdress(){
        return  buildingService.getAllAdress();
    }

    @GetMapping
    public List<LeasProBuilding> getAll(){
        return buildingService.getBuildings();
    }
}
