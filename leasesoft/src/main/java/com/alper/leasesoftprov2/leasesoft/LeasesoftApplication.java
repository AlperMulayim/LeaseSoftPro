package com.alper.leasesoftprov2.leasesoft;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableRabbit
public class LeasesoftApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeasesoftApplication.class, args);
	}

}
