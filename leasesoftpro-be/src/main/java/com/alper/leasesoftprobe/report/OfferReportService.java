package com.alper.leasesoftprobe.report;

import com.alper.leasesoftprobe.offers.entities.Offer;
import com.alper.leasesoftprobe.offers.services.OfferService;
import com.alper.leasesoftprobe.pdfgenerator.PDFGenerator;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class OfferReportService  implements  ReportService{
    @Autowired
    OfferService offerService;

    @Override
    public OfferReportData getReportData(Integer offerId){
        Optional<Offer>  offerOpt = offerService.getOffer(offerId);
        OfferReportData data = new OfferReportData();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

        if(offerOpt.isPresent()){
            Offer offer = offerOpt.get();
            data =  OfferReportData.builder()
                    .uuid(offer.getOfferUID())
                    .date(dateFormat.format(offer.getOfferDate()))
                    .dueDate(dateFormat.format(offer.getDueDate()))
                    .status(offer.getStatus().toString())
                    .build();
        }
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
        } catch (
                DocumentException e) {
            throw new RuntimeException(e);
        }

        return getReportData(reportId);
    }



}
