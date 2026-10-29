package com.dhoon.japantravel.city.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(
        name = "city",
        uniqueConstraints = @UniqueConstraint(name = "uk_city_name", columnNames = "city_name")
)
public class City {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Long id;

    @Column(name = "city_name", nullable = false)
    private String cityName;

    @Column(name = "recommend_trip_days", nullable = false)
    private int recommendTripDays;

    @Enumerated(EnumType.STRING)
    @Column(name = "city_type", nullable = false)
    private CityType cityType;

    public static City createCity(String cityName, int recommendTripDays, CityType cityType) {
        return new City(cityName, recommendTripDays, cityType);
    }

    private City(String cityName, int recommendTripDays, CityType cityType) {
        this.cityName = cityName;
        this.recommendTripDays = recommendTripDays;
        this.cityType = cityType;
    }
}
