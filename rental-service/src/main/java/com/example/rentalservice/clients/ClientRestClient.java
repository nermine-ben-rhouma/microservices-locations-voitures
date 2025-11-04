package com.example.rentalservice.clients;

import com.example.rentalservice.models.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "client-service", url = "http://localhost:8084")
public interface ClientRestClient {

    @GetMapping("/api/clients/{id}")
    Client getClientById(@PathVariable Long id);
}
