package com.learnSpringBoot.notificationcenter.config;

import com.learnSpringBoot.notificationcenter.exception.UnauthorizedException;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HttpServletBean;

@Component
public class ApiKeyInterceptor implements HandlerInterceptor {

    private final AppProperties appProperties;

    public ApiKeyInterceptor(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String key = request.getHeader("X-API-KEY");
        String expectedKey = appProperties.getKey();

        if (key == null || !key.equals(expectedKey)) {
            throw new UnauthorizedException("Invalid or missing API key");
        }
        return true;
    }
}

