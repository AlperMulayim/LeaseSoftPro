package com.alper.leasesoftprobe.report;

import java.io.ByteArrayOutputStream;

public interface ReportService {
    ByteArrayOutputStream generateReport(Integer dataId, ReportData reportData);
    ReportData getReportData(Integer dataId);
    ReportData save(ReportData data);
}
