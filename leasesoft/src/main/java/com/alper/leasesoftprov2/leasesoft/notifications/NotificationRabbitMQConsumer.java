package com.alper.leasesoftprov2.leasesoft.notifications;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component("notification-consumer-rabbitmq")
public class NotificationRabbitMQConsumer {

    private  LSNotificationDto notification = new LSNotificationDto();

    @RabbitListener(queues = {"notification_queue"})
    public void receive(@Payload LSNotificationDto notificationDto){
        this.notification = notificationDto;
    }

    public LSNotificationDto getNotification(){
        return this.notification;
    }
}
