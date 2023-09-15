package com.alper.leasesoftprov2.leasesoft.buildings.features;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingFeatureService {

    @Autowired
    private  BuildingFeatureRepository repository;

    public List<BuildingFeature> getAll(){
        return repository.findAll();
    }
}
