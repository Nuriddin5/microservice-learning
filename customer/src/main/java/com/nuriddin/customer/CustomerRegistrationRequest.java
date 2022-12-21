package com.nuriddin.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email
) {
}
