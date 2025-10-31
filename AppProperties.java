package com.learnSpringBoot.notificationcenter.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppProperties {

    @Value("${api.key}")
    private String key;

    public String getKey() {
        return key;
    }
}
