package com.dhoon.japantravel.city.service;

import com.dhoon.japantravel.city.domain.City;
import com.dhoon.japantravel.city.dto.response.TravelRecommendCitiesResponseDto;
import com.dhoon.japantravel.city.dto.response.TravelRecommendCityResponseDto;
import com.dhoon.japantravel.city.repository.CityRepository;
import com.dhoon.japantravel.city.dto.request.TravelRecommendRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Slf4j
@Transactional
@RequiredArgsConstructor
@Service
public class JapanTravelService {

    private final CityRepository cityRepository;

    public TravelRecommendCitiesResponseDto recommend(TravelRecommendRequestDto requestDto) {
        List<City> sameCityTypeCities = cityRepository.findByCityType(requestDto.getCityType());

        int clientTripDays = requestDto.getTripDays();

        sameCityTypeCities.sort(
                Comparator.comparingInt(city -> calculateDayDifference(city, clientTripDays))
        );

        List<TravelRecommendCityResponseDto> listCities = sameCityTypeCities.stream()
                .map(TravelRecommendCityResponseDto::of)
                .toList();

        return TravelRecommendCitiesResponseDto.of(listCities);
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
