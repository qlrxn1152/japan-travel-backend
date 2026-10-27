package com.dhoon.japantravel.city.service;

import com.dhoon.japantravel.city.domain.City;
import com.dhoon.japantravel.city.domain.CityType;
import com.dhoon.japantravel.city.repository.CityRepository;
import com.dhoon.japantravel.city.request.dto.TravelRecommendRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Slf4j
@Transactional
@RequiredArgsConstructor
@Service
public class JapanTravelService {

    private final CityRepository cityRepository;

    public List<City> recommend(TravelRecommendRequestDto requestDto) {
        List<City> sameCityTypeCities = cityRepository.findByCityType(requestDto.getCityType());

        int clientTripDays = requestDto.getTripDays();

        sameCityTypeCities.sort(
                Comparator.comparingInt(city -> calculateDayDifference(city, clientTripDays))
        );

        return sameCityTypeCities;
    }

    private int calculateDayDifference(City city, int tripDays) {
        if (tripDays < city.getRecommendMinDays()) {
            return city.getRecommendMinDays() - tripDays;
        }

        if (tripDays > city.getRecommendMaxDays()) {
            return tripDays - city.getRecommendMaxDays();
        }

        return 0;
    }

}
