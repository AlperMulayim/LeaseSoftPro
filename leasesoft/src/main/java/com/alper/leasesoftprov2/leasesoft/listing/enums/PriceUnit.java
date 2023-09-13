package com.alper.leasesoftprov2.leasesoft.listing.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum PriceUnit {
    @JsonProperty("$")
    USD,
    @JsonProperty("₺")
    TL,
    @JsonProperty("€")
    EUR
}
