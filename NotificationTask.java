package com.learnSpringBoot.notificationcenter.model;

public class NotificationTask {
    private String id;
    private String channel;
    private String recipient;
    private String message;
    private String status;

    public NotificationTask(String id, String channel, String recipient, String message) {
        this.channel = channel;
        this.id = id;
        this.recipient = recipient;
        this.message = message;
        this.status = "PENDING";
    }

    public String getChannel() {
        return channel;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
