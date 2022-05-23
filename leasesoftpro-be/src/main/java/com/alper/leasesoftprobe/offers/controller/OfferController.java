package com.alper.leasesoftprobe.offers.controller;

import com.alper.leasesoftprobe.offers.entities.Offer;
import com.alper.leasesoftprobe.offers.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/offers")
public class OfferController {
    @Autowired
    private OfferService offerService;

    @GetMapping("")
    public ResponseEntity<List<Offer>> getOffers(){
        return  ResponseEntity.ok(this.offerService.getOffers());
    }

    @PostMapping("")
    public Offer saveOffer(Offer offer){
        return  offerService.saveOffer(offer);
    }
}
