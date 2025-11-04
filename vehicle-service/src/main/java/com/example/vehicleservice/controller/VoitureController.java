package com.example.vehicleservice.controller;

import com.example.vehicleservice.entities.Voiture;
import com.example.vehicleservice.repositories.VoitureRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voitures")
@CrossOrigin("*")
public class VoitureController {

    private final VoitureRepository voitureRepository;

    public VoitureController(VoitureRepository voitureRepository) {
        this.voitureRepository = voitureRepository;
    }

    @GetMapping
    public List<Voiture> getAll() {
        return voitureRepository.findAll();
    }

    @GetMapping("/{id}")
    public Voiture getById(@PathVariable Long id) {
        return voitureRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Voiture save(@RequestBody Voiture voiture) {
        return voitureRepository.save(voiture);
    }
}
