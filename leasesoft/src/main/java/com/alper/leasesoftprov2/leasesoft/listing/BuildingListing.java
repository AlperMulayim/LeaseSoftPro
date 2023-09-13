package com.alper.leasesoftprov2.leasesoft.listing;

import com.alper.leasesoftprov2.leasesoft.buildings.Building;
import com.alper.leasesoftprov2.leasesoft.listing.enums.ListingStatus;
import com.alper.leasesoftprov2.leasesoft.listing.enums.ListingType;
import com.alper.leasesoftprov2.leasesoft.listing.enums.PriceUnit;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.Date;

@Entity
@Table(name="ldb_listings")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BuildingListing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "listing_code")
    private String code;

    @Column(name = "listing_status", columnDefinition = "enum", length = 255)
    @Enumerated(EnumType.STRING)
    private ListingStatus status;

    @Column(name = "listing_type", columnDefinition = "enum",length = 255)
    @Enumerated(EnumType.STRING)
    private ListingType type;

    @Column(name = "price_unit", columnDefinition = "enum",length = 255)
    @Enumerated(EnumType.STRING)
    private PriceUnit priceUnit;

    @Column(name = "price")
    private Double price;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "update_date")
    private Date updateDate;

}
