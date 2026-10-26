package com.dhoon.japantravel.internal.travel.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "destination")
public class Destination {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "destination_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "city_name", nullable = false)
    private CityName cityName;

    @Enumerated(EnumType.STRING)
    @Column(name = "city_type", nullable = false)
    private CityType cityType;

    @Enumerated(EnumType.STRING)
    @Column(name = "transport_level", nullable = false)
    private TransportLevel transportLevel;

    @Enumerated(EnumType.STRING)
    @Column(name = "cost_level", nullable = false)
    private CostLevel costLevel;

    @Column(name = "recommend_min_days", nullable = false)
    private int recommendMinDays;

    @Column(name = "recommend_max_days", nullable = false)
    private int recommendMaxDays;

    public static Destination createDestination(CityName cityName, CityType cityType, TransportLevel transportLevel, CostLevel costLevel, int recommendMinDays, int recommendMaxDays){
        return new Destination(cityName, cityType, transportLevel, costLevel, recommendMinDays, recommendMaxDays);
    }

    private Destination(CityName cityName, CityType cityType, TransportLevel transportLevel, CostLevel costLevel, int recommendMinDays, int recommendMaxDays) {
        this.cityName = cityName;
        this.cityType = cityType;
        this.transportLevel = transportLevel;
        this.costLevel = costLevel;
        this.recommendMinDays = recommendMinDays;
        this.recommendMaxDays = recommendMaxDays;
    }
}
