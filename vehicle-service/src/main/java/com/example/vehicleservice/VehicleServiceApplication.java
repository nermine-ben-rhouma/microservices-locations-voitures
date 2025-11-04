package com.example.vehicleservice;

import com.example.vehicleservice.entities.Voiture;
import com.example.vehicleservice.repositories.VoitureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class VehicleServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(VehicleServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(VoitureRepository repo) {
        return args -> {
            repo.save(new Voiture(null, "Toyota", "Yaris", 120.0, true));
            repo.save(new Voiture(null, "BMW", "X5", 250.0, true));
            repo.save(new Voiture(null, "Peugeot", "208", 100.0, false));
        };
    }
}
