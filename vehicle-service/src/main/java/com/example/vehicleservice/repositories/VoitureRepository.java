package com.example.vehicleservice.repositories;

import com.example.vehicleservice.entities.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoitureRepository extends JpaRepository<Voiture, Long> {
}
