package com.dhoon.japantravel.city.repository;

import com.dhoon.japantravel.city.domain.City;
import com.dhoon.japantravel.city.domain.CityType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {

    List<City> findAllByCityType(CityType cityType);
}
