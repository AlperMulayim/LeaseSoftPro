package com.alper.leasesoftprobe.offers.services;


import com.alper.leasesoftprobe.buildings.entities.BuildingUnit;
import com.alper.leasesoftprobe.buildings.services.BuildingUnitsService;
import com.alper.leasesoftprobe.contacts.entity.Contact;
import com.alper.leasesoftprobe.contacts.service.ContactService;
import com.alper.leasesoftprobe.offers.dtos.OfferDTO;
import com.alper.leasesoftprobe.offers.entities.Offer;
import com.alper.leasesoftprobe.offers.repositories.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OfferService {

    @Autowired
    private OfferRepository repository;

    @Autowired
    private ContactService contactService;
    @Autowired
    private BuildingUnitsService unitsService;
    public List<Offer> getOffers(){
        return  repository.findAll();
    }

    public Optional<Offer> getOffer(Integer id){
        return  repository.findById(id);
    }
    public Offer saveOffer(OfferDTO offerDTO){

        Contact contact = contactService.getContact(offerDTO.getContactId());
        Optional<BuildingUnit> unit = unitsService.getUnit(offerDTO.getUnitId());

        Offer offer = Offer.builder().contact(contact)
                .offerUID(UUID.randomUUID())
                .unit(unit.get())
                .dueDate(offerDTO.getDueDate())
                .offerDate(offerDTO.getDueDate())
                .discountRate(offerDTO.getDiscountRate())
                .commissionPrice(offerDTO.getCommissionPrice())
                .status(offerDTO.getStatus())
                .build();


       return repository.save(offer);
    }
}
