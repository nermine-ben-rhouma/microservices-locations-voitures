package com.example.vehicleservice.kafka;

import com.example.vehicleservice.models.Location;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(
            topics = "locations",
            groupId = "vehicle-group",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consume(Location location) {
        System.out.println("Message Kafka reçu : " + location);
    }
}
