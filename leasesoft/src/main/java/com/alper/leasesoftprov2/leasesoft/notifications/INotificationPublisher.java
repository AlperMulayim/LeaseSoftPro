package com.alper.leasesoftprov2.leasesoft.notifications;

import javax.management.Notification;

public interface INotificationPublisher {
    void send(LSNotificationDto notification);
}
