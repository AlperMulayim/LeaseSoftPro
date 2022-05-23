package com.alper.leasesoftprobe.offers.controller;

import com.alper.leasesoftprobe.offers.dtos.OfferDTO;
import com.alper.leasesoftprobe.offers.entities.Offer;
import com.alper.leasesoftprobe.offers.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Offer saveOffer(@RequestBody  OfferDTO offer){
      return   offerService.saveOffer(offer);
    }
}
