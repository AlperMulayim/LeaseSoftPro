package com.alper.leasesoftprov2.leasesoft.notifications;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component("notification-consumer-rabbitmq")
public class NotificationRabbitMQConsumer {
    @RabbitListener(queues = {"notification_queue"})
    public void receive(@Payload LSNotificationDto notificationDto){
        System.out.println("RECEİVED -> " + notificationDto.toString());
    }
}
