package com.alper.leasesoftprov2.leasesoft.buildings;

import com.alper.leasesoftprov2.leasesoft.buildings.filters.BuildingFilter;
import com.alper.leasesoftprov2.leasesoft.buildings.mappers.dtos.BuildingDto;
import jakarta.transaction.NotSupportedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/buildings")
public class BuildingController {
    @Autowired
    public  BuildingService service;

    @GetMapping("") //add filter, error handling. add pagination
    public List<BuildingDto> getAllBuildings(@RequestParam("beds") Optional<Integer> beds,
                                             @RequestParam("baths") Optional<Integer> baths,
                                             @RequestParam("city") Optional<String> city
    )  {

        BuildingFilter filter = BuildingFilter.builder()
                .beds(beds)
                .baths(baths)
                .city(city)
                .build();
        return this.service.getBuildings(filter);
    }
}
