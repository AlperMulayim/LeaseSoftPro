package com.alper.leasesoftprobe.offers.services;


import com.alper.leasesoftprobe.offers.entities.Offer;
import com.alper.leasesoftprobe.offers.repositories.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {

    @Autowired
    private OfferRepository repository;

    public List<Offer> getOffers(){
        return  repository.findAll();
    }

    public Offer saveOffer(Offer offer){
        return  repository.save(offer);
    }
}
