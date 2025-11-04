package com.example.rentalservice.models;

import lombok.Data;

@Data
public class Voiture {
    private Long id;
    private String marque;
    private String modele;
    private double prixParJour;
    private boolean disponible;
}
