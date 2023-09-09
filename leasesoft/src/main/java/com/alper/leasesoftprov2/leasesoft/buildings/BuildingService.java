package com.alper.leasesoftprov2.leasesoft.buildings;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingService {

    @Autowired
    private BuildingRepository repository;

    List<Building> getBuildings(){
        return repository.findAll();
    }
}
