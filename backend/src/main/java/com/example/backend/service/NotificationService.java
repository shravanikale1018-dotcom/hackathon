package com.example.backend.service;

import com.example.backend.model.Notification;
import com.example.backend.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    // Create notification
    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    // Get all notifications
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    // Get notifications by user
    public List<Notification> getNotificationsByUser(String userId) {
        return notificationRepository.findByUserId(userId);
    }

    // Mark notification as read
    public Notification markAsRead(String id) {

        Notification notification =
                notificationRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Notification not found"));

        notification.setRead(true);

        return notificationRepository.save(notification);
    }
}