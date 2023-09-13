package com.alper.leasesoftprov2.leasesoft.listing.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ListingType {
    @JsonProperty("mo")
    MONTHLY,
    @JsonProperty("day")
    DAILY,
    @JsonProperty("year")
    YEARLY
}
