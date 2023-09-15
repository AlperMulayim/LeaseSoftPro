package com.alper.leasesoftprov2.leasesoft.buildings.mappers.dtos;

import com.alper.leasesoftprov2.leasesoft.listing.ListingUnitService;
import com.alper.leasesoftprov2.leasesoft.listing.enums.ListingStatus;
import com.alper.leasesoftprov2.leasesoft.listing.enums.ListingType;
import com.alper.leasesoftprov2.leasesoft.listing.enums.PriceUnit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BuildingDto {
    private Integer id;
    private String name;
    private String city;
    private Double price;
    private Integer beds;
    private Integer baths;
    private Integer carSpaces;
    private Double size;
    private ListingType listingType;
    private ListingStatus status;
    private PriceUnit priceUnit;
    private BigDecimal lat;
    private BigDecimal lot;
    private String code;
    private String features;
}
