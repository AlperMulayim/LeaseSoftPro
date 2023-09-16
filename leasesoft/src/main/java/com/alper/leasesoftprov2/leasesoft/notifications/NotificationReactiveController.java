package com.alper.leasesoftprov2.leasesoft.notifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.stream.Stream;

@RestController
@RequestMapping("api/v1/notifications")
public class NotificationReactiveController {

    @Autowired
    NotificationRabbitMQConsumer rabbitMQConsumer;

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<String>> getNotification() throws IOException, InterruptedException {

        Flux notificationFlux = Flux.fromStream(Stream.of(rabbitMQConsumer.getNotification() != null
                        ? rabbitMQConsumer.getNotification() : ""))
                .interval(Duration.ofSeconds(2))
                .map(line -> {

                    return ServerSentEvent.<String>builder()
                            .data(rabbitMQConsumer.getNotification().getMessage() + " ----  " + LocalDateTime.now().toString())
                            .event("Notification")
                            .build();
                });

        return keepAlive(Duration.ofSeconds(3),
                notificationFlux, 1);

    }

    private <T> Flux keepAlive(Duration duration, Flux<T> data, Integer id) {
        Flux<ServerSentEvent<T>> heartBeat = Flux.interval(duration)
                .map(e -> ServerSentEvent.<T>builder()
                        .comment("keep alive for:" + id)
                        .build());
        return Flux.merge(heartBeat, data);
    }
}
