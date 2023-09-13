package com.alper.leasesoftprov2.leasesoft.buildings;

import com.alper.leasesoftprov2.leasesoft.buildings.filters.BuildingFilter;
import com.alper.leasesoftprov2.leasesoft.buildings.mappers.dtos.BuildingDto;
import jakarta.transaction.NotSupportedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/buildings")
public class BuildingController {
    @Autowired
    public  BuildingService service;

    @PostMapping("") //add filter, error handling. add pagination
    public List<BuildingDto> getAllBuildings(@RequestBody BuildingFilter filter) {
        return this.service.getBuildings(filter);
    }
}
