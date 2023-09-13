package com.alper.leasesoftprov2.leasesoft.buildings.mappers;


import com.alper.leasesoftprov2.leasesoft.buildings.Building;
import com.alper.leasesoftprov2.leasesoft.buildings.mappers.dtos.BuildingDto;
import com.alper.leasesoftprov2.leasesoft.mappers.IEntityMapper;
import jakarta.transaction.NotSupportedException;
import org.springframework.stereotype.Component;

@Component
public class BuildingMapper implements IEntityMapper<Building, BuildingDto> {
    @Override
    public BuildingDto toDTO(Building building) throws NotSupportedException {
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
                .build();
    }

    @Override
    public Building toEntity(BuildingDto buildingDto) throws NotSupportedException {
        throw new NotSupportedException();
    }
}
