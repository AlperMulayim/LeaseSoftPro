package com.alper.leasesoftprov2.leasesoft.buildings.filters;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BuildingFilter {
    private Optional<Integer> beds;
    private Optional<Integer> baths;
    private Optional<String> city;
}
