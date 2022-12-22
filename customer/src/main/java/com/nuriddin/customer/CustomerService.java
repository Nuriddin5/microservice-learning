package com.nuriddin.customer;

import com.nuriddin.clients.fraud.FraudCheckResponse;
import com.nuriddin.clients.fraud.FraudClient;
import com.nuriddin.clients.notification.NotificationClient;
import com.nuriddin.clients.notification.NotificationRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService(CustomerRepository customerRepository,
                              RestTemplate restTemplate,
                              FraudClient fraudClient,
                              NotificationClient notificationClient) {

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email()).build();

        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("Customer is fraudster");
        }
        notificationClient.sendNotification(new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                String.format("Assalomu alaykum %s, welcome to Nuriddin's code",customer.getFirstName())
        ));

    }
}
