package com.example.vehicleservice.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

public class Location {
    private Long id;
    private Long idClient;
    private Long idVoiture;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateDebut;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateFin;

    private Double montantTotal;

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getIdClient() { return idClient; }
    public void setIdClient(Long idClient) { this.idClient = idClient; }

    public Long getIdVoiture() { return idVoiture; }
    public void setIdVoiture(Long idVoiture) { this.idVoiture = idVoiture; }

    public LocalDate getDateDebut() { return dateDebut; }
    public void setDateDebut(LocalDate dateDebut) { this.dateDebut = dateDebut; }

    public LocalDate getDateFin() { return dateFin; }
    public void setDateFin(LocalDate dateFin) { this.dateFin = dateFin; }

    public Double getMontantTotal() { return montantTotal; }
    public void setMontantTotal(Double montantTotal) { this.montantTotal = montantTotal; }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", idClient=" + idClient +
                ", idVoiture=" + idVoiture +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", montantTotal=" + montantTotal +
                '}';
    }
}
