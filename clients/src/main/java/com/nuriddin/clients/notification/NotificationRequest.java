package com.nuriddin.clients.notification;

public record NotificationRequest(Integer toCustomerId,
                                  String toCustomerEmail,
                                  String message) {

}
