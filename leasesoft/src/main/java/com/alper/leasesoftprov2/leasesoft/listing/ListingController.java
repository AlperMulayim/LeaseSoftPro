package com.alper.leasesoftprov2.leasesoft.listing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/units/listings")
public class ListingController {

    @Autowired
    private ListingUnitService listingUnitService;

    @GetMapping()
    private List<BuildingListing> getListings(){
        return listingUnitService.findAll();
    }
}
