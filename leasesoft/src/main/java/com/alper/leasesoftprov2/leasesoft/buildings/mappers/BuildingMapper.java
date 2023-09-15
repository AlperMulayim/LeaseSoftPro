package com.alper.leasesoftprov2.leasesoft.buildings.mappers;


import com.alper.leasesoftprov2.leasesoft.buildings.Building;
import com.alper.leasesoftprov2.leasesoft.buildings.features.BuildingFeature;
import com.alper.leasesoftprov2.leasesoft.buildings.mappers.dtos.BuildingDto;
import com.alper.leasesoftprov2.leasesoft.mappers.IEntityMapper;
import jakarta.transaction.NotSupportedException;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class BuildingMapper implements IEntityMapper<Building, BuildingDto> {
    @Override
    public BuildingDto toDTO(Building building) throws NotSupportedException {
        String  features = building.getFeatures().stream()
                .map(BuildingFeature::getName)
                .collect(Collectors.joining(", "));

        return BuildingDto.builder()
                .name(building.getBlockName())
                .id(building.getId())
                .status(building.getListing().getStatus())
                .listingType(building.getListing().getType())
                .baths(building.getBathrooms())
                .beds(building.getBedrooms())
                .carSpaces(building.getCarSpaces())
                .lat(building.getLat())
                .lot(building.getLot())
                .city(building.getCity())
                .price(building.getListing().getPrice())
                .priceUnit(building.getListing().getPriceUnit())
                .size(building.getSize())
                .code(building.getListing().getCode())
                .features(features)
                .build();
    }

    @Override
    public Building toEntity(BuildingDto buildingDto) throws NotSupportedException {
        throw new NotSupportedException();
    }
}
