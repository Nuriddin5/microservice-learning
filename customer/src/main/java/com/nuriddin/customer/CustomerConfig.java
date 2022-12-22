package com.nuriddin.customer;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomerConfig {
    @Bean
    @LoadBalanced
    //todo think about loadbalancing in openfeign
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
