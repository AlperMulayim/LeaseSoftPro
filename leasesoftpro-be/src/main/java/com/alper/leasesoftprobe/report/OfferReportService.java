package com.alper.leasesoftprobe.report;

import com.alper.leasesoftprobe.buildings.entities.BuildingUnit;
import com.alper.leasesoftprobe.buildings.entities.LeasProBuilding;
import com.alper.leasesoftprobe.buildings.services.LeasProBuildingService;
import com.alper.leasesoftprobe.contacts.entity.Contact;
import com.alper.leasesoftprobe.contacts.service.ContactService;
import com.alper.leasesoftprobe.offers.entities.Offer;
import com.alper.leasesoftprobe.offers.services.OfferService;
import com.alper.leasesoftprobe.pdfgenerator.PDFGenerator;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class OfferReportService  implements  ReportService{
    @Autowired
    OfferService offerService;

    @Autowired
    LeasProBuildingService buildingService;

    @Autowired
    ReportRepository repository;

    @Override
    public OfferReportData getReportData(Integer offerId){
        Optional<Offer>  offerOpt = offerService.getOffer(offerId);

        OfferReportData data = new OfferReportData();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

        if(offerOpt.isPresent()){
            Offer offer = offerOpt.get();
            Contact contact = offer.getContact();
            BuildingUnit unit = offer.getUnit();
            LeasProBuilding building = buildingService.getBuilding(unit.getBuildingId()).get();

            data =  OfferReportData.builder()
                    .uuid(offer.getOfferUID())
                    .date(dateFormat.format(offer.getOfferDate()))
                    .dueDate(dateFormat.format(offer.getDueDate()))
                    .status(offer.getStatus().toString())
                    .username(contact.getUsername() +" " + contact.getSurname() + " - " + contact.getContactUuid())
                    .address(contact.getAdress())
                    .email(contact.getEmail())
                    .phone(contact.getPhoneNumber())
                    .buildingAdress(building.getAdress().getStreet() + " / " + building.getAdress().getCity())
                    .area(unit.getArea())
                    .buildingName(building.getName())
                    .type(unit.getUnitType().name())
                    .period(unit.getPricePeriod().name())
                    .floor(unit.getFloorId())
                    .price(unit.getPrice())
                    .reportId(UUID.randomUUID())
                    .build();
        }
        save(data);
        return  data;
    }

    @Override
    public ReportData generateReport(Integer reportId, ReportData reportData) {

        PDFGenerator pdfGenerator = new PDFGenerator();
        Map<String, Object> data = new HashMap<>();
        data.put("offers",reportData);
        String str = pdfGenerator.parseThymeleafTemplate("thymeleaf_template.html",data);
        try {
            pdfGenerator.generatePdfFromHtml(str,"offer");
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }

        return getReportData(reportId);
    }

    @Override
    public ReportData save(ReportData data) {

        OfferReportData  offerReport = (OfferReportData) data;
        Report report = Report.builder()
                .reportId(offerReport.getReportId())
                .username(offerReport.getUsername())
                .date(new Date()).build();
        repository.save(report);
        return  data;
    }


}
