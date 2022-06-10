package com.alper.leasesoftprobe.report;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OfferReportData implements  ReportData {
    UUID uuid;
    String date;
    String dueDate;
    String status;
}
