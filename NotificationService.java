package com.learnSpringBoot.notificationcenter.service;

import com.learnSpringBoot.notificationcenter.exception.InvalidChannelException;
import com.learnSpringBoot.notificationcenter.model.NotificationTask;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
@Service
public class NotificationService {
    private final EmailService emailService;
    private final SlackService slackService;
    private final Map<String , NotificationTask> taskMap = new ConcurrentHashMap<>();

    public NotificationService(EmailService emailService, SlackService slackService) {
        this.emailService = emailService;
        this.slackService = slackService;
    }
    public NotificationTask createTask(String channel , String recipient , String message){
        String id = UUID.randomUUID().toString();
        NotificationTask task = new NotificationTask(id, channel, recipient, message);
        taskMap.put(id, task);
        processAsync(task);
        return task;
    }
    @Async
    public void processAsync(NotificationTask task){
      try{
          switch (task.getChannel().toLowerCase()){
              case  "email" -> emailService.send(task);
              case "slack" -> slackService.send(task);
              default -> throw new InvalidChannelException("Channel Not known: "+ task.getChannel());
          }
          task.setStatus("SUCCESS");
      }
      catch (Exception e){
          task.setStatus(" Failed: " + e.getMessage());

      }
    }
    public NotificationTask getTask(String id){
        return taskMap.get(id);
    }
}
