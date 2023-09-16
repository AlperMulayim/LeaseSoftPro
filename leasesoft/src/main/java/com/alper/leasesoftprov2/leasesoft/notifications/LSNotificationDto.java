package com.alper.leasesoftprov2.leasesoft.notifications;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LSNotificationDto{
    private Integer id;
    private String message;
    private Date date;
}
