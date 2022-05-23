package com.alper.leasesoftprobe.offers.entities;

import com.alper.leasesoftprobe.buildings.entities.BuildingUnit;
import com.alper.leasesoftprobe.contacts.entity.Contact;
import com.alper.leasesoftprobe.offers.enums.OfferStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "lesapro_offers")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;

    @Column(name = "offer_uid", updatable = false)
    private UUID offerUID = UUID.randomUUID();

    @OneToOne
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private Contact contact;

    @OneToOne
    @JoinColumn(name = "unit_id", referencedColumnName = "id")
    private BuildingUnit unit;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "offer_status")
    private OfferStatus status;

    @JsonFormat(pattern = "MM.dd.YYYY")
    @Column(name = "offer_date")
    private Date offerDate;

    @JsonFormat(pattern = "MM.dd.YYYY")
    @Column(name = "offer_end_date")
    private Date dueDate;

    @Column(name = "discount_rate")
    private Double discountRate;

    @Column(name = "commission_price")
    private Double commissionPrice;

}
