package com.alper.leasesoftprobe.offers.dtos;

import com.alper.leasesoftprobe.offers.enums.OfferStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferDTO {
    private UUID contactId;
    private Integer unitId;
    @JsonFormat(pattern = "MM.dd.YYYY")
    private Date dueDate;
    private Double discountRate;
    private Double commissionPrice;
    private OfferStatus status;
}
