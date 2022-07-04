package com.alper.leasesoftprobe.report;

import com.alper.leasesoftprobe.buildings.entities.BuildingUnit;
import com.alper.leasesoftprobe.buildings.entities.LeasProBuilding;
import com.alper.leasesoftprobe.buildings.services.LeasProBuildingService;
import com.alper.leasesoftprobe.contacts.entity.Contact;
import com.alper.leasesoftprobe.contacts.service.ContactService;
import com.alper.leasesoftprobe.offers.entities.Offer;
import com.alper.leasesoftprobe.offers.services.OfferService;
import com.alper.leasesoftprobe.pdfgenerator.PDFGenerator;
import com.alper.leasesoftprobe.vipservices.entities.VipOperations;
import com.alper.leasesoftprobe.vipservices.services.VipOperationsService;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class OfferReportService  implements  ReportService{
    @Autowired
    OfferService offerService;

    @Autowired
    LeasProBuildingService buildingService;

    @Autowired
    ReportRepository repository;
    @Autowired
    VipOperationsService operationsService;

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
            List<VipOperations> vipOperations = operationsService.getVipOperations();

            List<VipOperations> unitOperations = vipOperations.stream()
                    .filter(v-> v.getUnits().contains(unit))
                    .collect(Collectors.toList());

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
                    .services(unitOperations)
                    .reportId(UUID.randomUUID())
                    .build();
        }
        save(data);
        return  data;
    }

    @Override
    public ByteArrayOutputStream generateReport(Integer reportId, ReportData reportData) {

        PDFGenerator pdfGenerator = new PDFGenerator();
        Map<String, Object> data = new HashMap<>();
        OfferReportData offerData = (OfferReportData) reportData;
        data.put("offers",offerData);
        data.put("services",offerData.getServices());
        String str = pdfGenerator.parseThymeleafTemplate("thymeleaf_template.html",data);
        try {
           return pdfGenerator.generatePdfFromHtml(str,"offer");
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public ReportData save(ReportData data) {

        OfferReportData  offerReport = (OfferReportData) data;
        Report report = Report.builder()
                .reportId(offerReport.getReportId())
                .username(offerReport.getUsername())
                .date(new Date())
                .data(data.toString())
                .build();
        repository.save(report);
        return  data;
    }


}
