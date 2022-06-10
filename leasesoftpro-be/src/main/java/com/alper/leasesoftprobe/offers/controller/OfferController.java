package com.alper.leasesoftprobe.offers.controller;

import com.alper.leasesoftprobe.offers.dtos.OfferDTO;
import com.alper.leasesoftprobe.offers.entities.Offer;
import com.alper.leasesoftprobe.offers.services.OfferService;
import com.alper.leasesoftprobe.pdfgenerator.PDFGenerator;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/offers")
public class OfferController {
    @Autowired
    private OfferService offerService;

    @GetMapping("")
    public ResponseEntity<List<Offer>> getOffers(){
        List<Offer> offers = this.offerService.getOffers();
        return  ResponseEntity.ok(offers);

    }

    @PostMapping
    public Offer saveOffer(@RequestBody  OfferDTO offer){
      return   offerService.saveOffer(offer);
    }
}
