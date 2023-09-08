package com.alper.leasesoftprobe.report.controller;

import com.alper.leasesoftprobe.offers.services.OfferService;
import com.alper.leasesoftprobe.report.OfferReportData;
import com.alper.leasesoftprobe.report.ReportData;
import com.alper.leasesoftprobe.report.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

@RestController
@RequestMapping("api/v1/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping(value = "/offers/{id}",produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> getOfferReport(@PathVariable(name = "id") Integer id){
        ReportData data = reportService.getReportData(id);

        ByteArrayOutputStream outputStream = reportService.generateReport(id,data);

        var headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=offer_report.pdf");

        InputStream in = new ByteArrayInputStream(outputStream.toByteArray());
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(in));

    }
}
