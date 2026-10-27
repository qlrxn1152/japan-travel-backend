package com.dhoon.japantravel.city.dto.response;

import com.dhoon.japantravel.city.domain.City;
import com.dhoon.japantravel.city.domain.CityType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TravelRecommendCityResponseDto {

    private String cityName;
    private int recommendMinDays;
    private int recommendMaxDays;
    private CityType cityType;

    public static TravelRecommendCityResponseDto of(City city) {
        return new TravelRecommendCityResponseDto(
                city.getCityName(),
                city.getRecommendMinDays(),
                city.getRecommendMaxDays(),
                city.getCityType()
        );
    }




}
