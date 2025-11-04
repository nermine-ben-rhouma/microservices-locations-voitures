package com.example.rentalservice.web;

import com.example.rentalservice.clients.ClientRestClient;
import com.example.rentalservice.clients.VehicleRestClient;
import com.example.rentalservice.entities.Location;
import com.example.rentalservice.kafka.KafkaProducerService;
import com.example.rentalservice.models.Client;
import com.example.rentalservice.models.Voiture;
import com.example.rentalservice.repositories.LocationRepository;
import org.springframework.web.bind.annotation.*;

import java.time.temporal.ChronoUnit;
import java.util.List;

@RestController
@RequestMapping("/api/locations")
@CrossOrigin(origins = "*")
public class LocationController {

    private final LocationRepository repo;
    private final ClientRestClient clientRest;
    private final VehicleRestClient vehicleRest;
    private final KafkaProducerService kafkaProducer;

    public LocationController(LocationRepository repo, ClientRestClient clientRest, VehicleRestClient vehicleRest,
                              KafkaProducerService kafkaProducer) {
        this.repo = repo;
        this.clientRest = clientRest;
        this.vehicleRest = vehicleRest;
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping
    public List<Location> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Location create(@RequestBody Location location) {
        // Appels Feign
        Client client = clientRest.getClientById(location.getIdClient());
        Voiture voiture = vehicleRest.getVoitureById(location.getIdVoiture());

        // Calcul du montant
        long nbJours = ChronoUnit.DAYS.between(location.getDateDebut(), location.getDateFin());
        double montant = nbJours * voiture.getPrixParJour();
        location.setMontantTotal(montant);

        // Enregistrer location
        Location savedLocation = repo.save(location);

        // Envoyer au topic Kafka
        kafkaProducer.sendLocationEvent(savedLocation);

        return savedLocation;
    }
}
