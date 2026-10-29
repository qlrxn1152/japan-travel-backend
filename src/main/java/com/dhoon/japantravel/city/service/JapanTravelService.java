package com.dhoon.japantravel.city.service;

import com.dhoon.japantravel.city.domain.City;
import com.dhoon.japantravel.city.domain.CityType;
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

        CityType requestCityType = requestDto.getCityType();
        int requestTripDays = requestDto.getTripDays();

        List<TravelRecommendCityResponseDto> listCities = cityRepository.findAllByCityType(requestCityType)
                .stream()
                .sorted(
                        Comparator.comparingInt((City city) -> calculate(city, requestTripDays))
                                .thenComparingInt(City::getRecommendTripDays)
                )
                .map(TravelRecommendCityResponseDto::of)
                .toList();

        return TravelRecommendCitiesResponseDto.of(listCities);
    }

    private int calculate(City city, int requestTripDays) {
        int recommendTripDays = city.getRecommendTripDays();

        return Math.abs(recommendTripDays - requestTripDays);
    }



}
