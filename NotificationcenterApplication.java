package com.learnSpringBoot.notificationcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication

@ConfigurationPropertiesScan("com.learnSpringBoot.notificationcenter.config")
public class NotificationcenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationcenterApplication.class, args);
	}

}
