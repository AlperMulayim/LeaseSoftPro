package com.alper.leasesoftprobe.report;

public interface ReportService {
    ReportData generateReport(Integer dataId,ReportData reportData);
    ReportData getReportData(Integer dataId);
}
