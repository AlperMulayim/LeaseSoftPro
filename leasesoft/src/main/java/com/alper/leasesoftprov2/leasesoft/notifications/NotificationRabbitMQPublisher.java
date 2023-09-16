package com.alper.leasesoftprov2.leasesoft.notifications;

import org.springframework.amqp.core.Queue;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component("notification-publisher-rabbitmq")
public class NotificationRabbitMQPublisher  implements  INotificationPublisher{

    @Autowired
    private RabbitTemplate template;

    @Qualifier("notification_queue")
    @Autowired
    private Queue notificationQueue;

    @Qualifier("notification_exchange")
    @Autowired
    private DirectExchange notificationExchange;


    public void send(LSNotificationDto notification){
        template.convertAndSend(notificationExchange.getName(),"notifications_keys", notification);
    }
}
