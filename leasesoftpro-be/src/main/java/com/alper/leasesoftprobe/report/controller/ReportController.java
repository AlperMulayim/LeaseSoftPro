package com.alper.leasesoftprobe.report.controller;

import com.alper.leasesoftprobe.offers.services.OfferService;
import com.alper.leasesoftprobe.report.OfferReportData;
import com.alper.leasesoftprobe.report.ReportData;
import com.alper.leasesoftprobe.report.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/offer")
    public ReportData getOfferReport(){
        ReportData data = reportService.getReportData(8);
        return  reportService.generateReport(8, data);
    }
}
