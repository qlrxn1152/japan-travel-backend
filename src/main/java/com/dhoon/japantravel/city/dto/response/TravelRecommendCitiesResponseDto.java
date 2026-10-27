package com.dhoon.japantravel.city.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TravelRecommendCitiesResponseDto {

    List<TravelRecommendCityResponseDto> listCities;

    public static TravelRecommendCitiesResponseDto of(List<TravelRecommendCityResponseDto> listCities) {
        return new TravelRecommendCitiesResponseDto(listCities);
    }
}
