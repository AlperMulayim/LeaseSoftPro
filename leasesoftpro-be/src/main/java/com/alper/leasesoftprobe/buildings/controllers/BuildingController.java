package com.alper.leasesoftprobe.buildings.controllers;

import com.alper.leasesoftprobe.buildings.entities.BuildingAdress;
import com.alper.leasesoftprobe.buildings.entities.LeasProBuilding;
import com.alper.leasesoftprobe.buildings.services.BuildingAdressService;
import com.alper.leasesoftprobe.buildings.services.LeasProBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/buildings")
public class BuildingController {

    @Autowired
    public LeasProBuildingService buildingService;

    @Autowired
    public BuildingAdressService adressService;

    @GetMapping("/adress")
    public ResponseEntity <List<BuildingAdress>> getAdress(@RequestParam(name = "id") Optional<Integer> id){
        List<BuildingAdress> adresses = buildingService.getAllAdress(id);
        if(adresses.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return  ResponseEntity.ok(buildingService.getAllAdress(id));
    }

    @GetMapping
    public ResponseEntity<List<LeasProBuilding>> getBuildings(@RequestParam(name = "id") Optional<Integer> id){
        List<LeasProBuilding> buildings = new LinkedList<>();
        if(id.isPresent()){
            Optional<LeasProBuilding> building = buildingService.getBuilding(id.get());
            if(building.isPresent()){
                buildings.add(building.get());
                return ResponseEntity.ok(buildings);
            }else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        buildings = buildingService.getBuildings();
        return ResponseEntity.ok(buildings);
    }

    @PostMapping
    public ResponseEntity<LeasProBuilding> addBuilding(@RequestBody LeasProBuilding building){
        LeasProBuilding saved = buildingService.addBuilding(building);
        return  ResponseEntity.ok(saved);
    }

    @PostMapping("/adress")
    public ResponseEntity<BuildingAdress> addAdress(@RequestBody BuildingAdress adress) throws Exception{
        BuildingAdress saved = adressService.save(adress);
        return ResponseEntity.ok(saved);
    }
}
