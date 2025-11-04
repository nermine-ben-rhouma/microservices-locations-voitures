package com.example.rentalservice.clients;

import com.example.rentalservice.models.Voiture;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "vehicle-service", url = "http://localhost:8085")
public interface VehicleRestClient {

    @GetMapping("/api/voitures/{id}")
    Voiture getVoitureById(@PathVariable Long id);
}
