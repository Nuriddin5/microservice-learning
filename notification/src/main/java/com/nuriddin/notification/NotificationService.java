package com.nuriddin.notification;

import com.nuriddin.clients.notification.NotificationRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public record NotificationService(NotificationRepository notificationRepository) {

    public void sendNotification(NotificationRequest request) {

        notificationRepository.save(
                Notification.builder()
                        .toCustomerId(request.toCustomerId())
                        .toCustomerEmail(request.toCustomerEmail())
                        .sender("Nuriddin")
                        .message(request.message())
                        .sentAt(LocalDateTime.now())
                        .build()
        );
    }
}
