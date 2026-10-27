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

    @Column(name = "recommend_min_days")
    private int recommendMinDays;

    @Column(name = "recommend_max_days")
    private int recommendMaxDays;

    @Column(name = "city_type", nullable = false)
    private CityType cityType;

    public static City createCity(String cityName, int recommendMinDays, int recommendMaxDays, CityType cityType) {
        return new City(cityName, recommendMinDays, recommendMaxDays, cityType);
    }



    private City(String cityName, int recommendMinDays, int recommendMaxDays, CityType cityType) {
        this.cityName = cityName;
        this.recommendMinDays = recommendMinDays;
        this.recommendMaxDays = recommendMaxDays;
        this.cityType = cityType;
    }
}
