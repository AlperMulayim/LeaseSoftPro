package com.alper.leasesoftprov2.leasesoft.buildings;

import com.alper.leasesoftprov2.leasesoft.buildings.filters.BuildingFilter;
import com.alper.leasesoftprov2.leasesoft.buildings.filters.BuildingSpecification;
import com.alper.leasesoftprov2.leasesoft.buildings.mappers.BuildingMapper;
import com.alper.leasesoftprov2.leasesoft.buildings.mappers.dtos.BuildingDto;
import jakarta.transaction.NotSupportedException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuildingService {

    @Autowired
    private BuildingRepository repository;

    @Autowired
    private BuildingMapper mapper;

    @Autowired
    private BuildingSpecification buildingSpecification;

    List<BuildingDto> getBuildings(BuildingFilter filter)  {
        Specification<Building> specification = buildingSpecification.filterBy(filter);
        return repository.findAll(specification).stream().map(building -> {
            try {
                return mapper.toDTO(building);
            } catch (NotSupportedException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());
    }
}
