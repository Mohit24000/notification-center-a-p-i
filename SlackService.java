package com.learnSpringBoot.notificationcenter.service;

import com.learnSpringBoot.notificationcenter.aop.LogExecutionTime;
import com.learnSpringBoot.notificationcenter.model.NotificationTask;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(name = "channel.slack.enabled", havingValue = "true")
public class SlackService {
    @LogExecutionTime
    public void send(NotificationTask task) throws InterruptedException {
        Thread.sleep(2000); // here we are simulating the delay that occur in real world application
        System.out.println(" Sent Slack Message : " + task.getMessage());
    }
}
