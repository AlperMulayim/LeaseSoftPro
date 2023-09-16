package com.alper.leasesoftprov2.leasesoft.notifications;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Qualifier("notification_queue_config")
public class NotificationConfiguration {

    @Bean(name = "notification_queue")
    public Queue notificationQueue(){
        return new Queue("notification_queue",true);
    }

    @Bean(name = "notification_exchange")
    public DirectExchange directExchange(){
        return new DirectExchange("notification_exchange");
    }

    @Bean
    MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean(name = "notification_bindings")
    public Declarables directExchangeBindings(){
        return new Declarables(BindingBuilder.bind(notificationQueue()).to(directExchange()).with("notifications_keys"));
    }
}
