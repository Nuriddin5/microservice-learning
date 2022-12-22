package com.nuriddin.notification;

import com.nuriddin.clients.notification.NotificationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/notification")
@Slf4j
public record NotificationController(NotificationService notificationService,
                                     NotificationRepository repository) {
    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest notificationRequest) {
        log.info("New notification {}", notificationRequest);
        notificationService.sendNotification(notificationRequest);
    }
    @GetMapping
    public HttpEntity<?> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }
}
