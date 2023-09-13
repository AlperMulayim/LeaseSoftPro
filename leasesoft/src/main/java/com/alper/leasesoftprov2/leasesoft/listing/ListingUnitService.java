package com.alper.leasesoftprov2.leasesoft.listing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListingUnitService {

    @Autowired
    private ListingRepository repository;

    public List<BuildingListing> findAll(){
        return repository.findAll();
    }
}
