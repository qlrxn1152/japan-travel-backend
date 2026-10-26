package com.dhoon.japantravel.internal.travel.repository;

import com.dhoon.japantravel.internal.travel.domain.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationRepository extends JpaRepository<Destination, Long> {
}
