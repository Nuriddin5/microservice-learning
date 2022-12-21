package com.nuriddin.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public record CustomerController(
        CustomerService customerService,
        CustomerRepository customerRepository
) {

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
        log.info("new customer registration {}", customerRegistrationRequest);

        customerService.registerCustomer(customerRegistrationRequest);

    }

    @GetMapping
    public HttpEntity<?> getAll() {
        return ResponseEntity.ok(customerRepository.findAll());
    }
}
