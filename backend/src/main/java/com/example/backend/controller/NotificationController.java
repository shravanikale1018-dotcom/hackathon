package com.example.backend.controller;

import com.example.backend.model.Notification;
import com.example.backend.service.NotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
@CrossOrigin
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(
            NotificationService notificationService) {

        this.notificationService = notificationService;
    }

    @PostMapping
    public Notification createNotification(
            @RequestBody Notification notification) {

        return notificationService
                .createNotification(notification);
    }

    @GetMapping
    public List<Notification> getAllNotifications() {
        return notificationService
                .getAllNotifications();
    }

    @GetMapping("/user/{userId}")
    public List<Notification> getByUser(
            @PathVariable String userId) {

        return notificationService
                .getNotificationsByUser(userId);
    }

    @PutMapping("/read/{id}")
    public Notification markAsRead(
            @PathVariable String id) {

        return notificationService
                .markAsRead(id);
    }
}