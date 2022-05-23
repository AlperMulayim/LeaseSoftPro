package com.alper.leasesoftprobe.offers.repositories;

import com.alper.leasesoftprobe.offers.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Integer> {
}
