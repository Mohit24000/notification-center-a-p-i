package com.learnSpringBoot.notificationcenter.controller;

import com.learnSpringBoot.notificationcenter.model.NotificationTask;
import com.learnSpringBoot.notificationcenter.service.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/notify")
public class NotificationController {
    private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<?> createNotification(@RequestBody Map<String, Object> body){
        String channel = body.get("channel").toString();
        String recipient = body.get("recipient").toString();
        String message = body.get("message").toString();

        NotificationTask task = service.createTask(channel, recipient, message);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(Map.of("TaskId", task.getId(), "Status", task.getStatus()));

    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getStatus(@PathVariable String id){
        NotificationTask task = service.getTask(id);
        if(task == null){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("Error", "Task not found"));
        }
        return  ResponseEntity.ok(task);
    }
}
