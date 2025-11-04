package com.example.rentalservice.kafka;

import com.example.rentalservice.entities.Location;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, Location> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, Location> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendLocationEvent(Location location) {
        kafkaTemplate.send("locations", location);
        System.out.println("Envoi au topic Kafka : " + location);
    }
}
