package com.learnSpringBoot.notificationcenter.exception;

public class InvalidChannelException extends RuntimeException{

    public InvalidChannelException(String message) {
        super(message);
    }
}
