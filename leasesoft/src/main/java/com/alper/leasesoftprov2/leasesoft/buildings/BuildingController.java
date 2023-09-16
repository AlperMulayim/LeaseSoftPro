package com.alper.leasesoftprov2.leasesoft.buildings;

import com.alper.leasesoftprov2.leasesoft.buildings.filters.BuildingFilter;
import com.alper.leasesoftprov2.leasesoft.buildings.mappers.dtos.BuildingDto;
import com.alper.leasesoftprov2.leasesoft.notifications.INotificationPublisher;
import com.alper.leasesoftprov2.leasesoft.notifications.LSNotificationDto;
import com.alper.leasesoftprov2.leasesoft.notifications.NotificationRabbitMQPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/buildings")
public class BuildingController {
    @Autowired
    public  BuildingService service;

    @Autowired
    @Qualifier("notification-publisher-rabbitmq")
    public INotificationPublisher notificationPublisher;

    @PostMapping("") //add filter, error handling. add pagination
    public List<BuildingDto> getAllBuildings(@RequestBody BuildingFilter filter) {
        LSNotificationDto notification = LSNotificationDto.builder()
                .id(1)
                .message("Filter Occurs " + filter.toString())
                .date(new Date())
                .build();
        notificationPublisher.send(notification);
        return this.service.getBuildings(filter);
    }
}
