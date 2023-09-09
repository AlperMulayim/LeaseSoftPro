package com.alper.leasesoftprov2.leasesoft.buildings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/buildings")
public class BuildingController {
    @Autowired
    public  BuildingService service;

    @GetMapping("") //add filter, error handling. add pagination
    public List<Building> getAllBuildings(){
        return this.service.getBuildings().stream().limit(12).collect(Collectors.toList());
    }
}
