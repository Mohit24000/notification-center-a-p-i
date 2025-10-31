package com.learnSpringBoot.notificationcenter.service;

import com.learnSpringBoot.notificationcenter.aop.LogExecutionTime;
import com.learnSpringBoot.notificationcenter.model.NotificationTask;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(name = "channel.email.enabled" , havingValue = "true")
public class EmailService {
    @LogExecutionTime
    public void send(NotificationTask task) throws InterruptedException {
        Thread.sleep(1500 ) ; // same here simulate delay
        System.out.println(" Sent Email to : " + task.getRecipient() + ": " + task.getMessage());
    }
}
