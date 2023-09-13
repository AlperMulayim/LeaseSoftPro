package com.alper.leasesoftprov2.leasesoft.buildings.filters;

import com.alper.leasesoftprov2.leasesoft.buildings.Building;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BuildingSpecification {

    public Specification<Building> filterBy(BuildingFilter filter){
        return Specification
                .where(hasBeds(filter.getBeds()))
                .and(hasBaths(filter.getBaths()))
                .and(inCity(filter.getCity()));
    }

    Specification<Building> hasBeds(Optional<Integer> beds){
        return (((root, query, criteriaBuilder) -> beds.isPresent() ?
                criteriaBuilder.equal(root.get("bedrooms"),beds.get()):
                criteriaBuilder.conjunction()));
    }

    Specification<Building> hasBaths(Optional<Integer> baths){
        return (((root, query, criteriaBuilder) -> baths.isPresent() ?
                criteriaBuilder.equal(root.get("bathrooms"),baths.get()):
                criteriaBuilder.conjunction() ));
    }

    Specification<Building> inCity(Optional<String> city){
        return (((root, query, criteriaBuilder) -> city.isPresent() && !city.get().isEmpty() ?
                criteriaBuilder.equal(root.get("city"),city.get()):
                criteriaBuilder.conjunction()));
    }
}
