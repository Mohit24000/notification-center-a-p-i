package com.learnSpringBoot.notificationcenter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<?> handlerUnauthorised(UnauthorizedException e){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Map.of("Error ", e.getMessage()));
    }
    @ExceptionHandler(InvalidChannelException.class)
    public ResponseEntity<?> handlerInvalidChannel(InvalidChannelException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of("Error ", e.getMessage()));
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handlerGeneric(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("Error ", e.getMessage()));
    }
}
