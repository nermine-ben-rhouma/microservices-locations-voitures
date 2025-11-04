package com.example.rentalservice.repositories;

import com.example.rentalservice.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Long> {
}
