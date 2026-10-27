package com.dhoon.japantravel.city.service;

import com.dhoon.japantravel.city.domain.City;
import com.dhoon.japantravel.city.domain.CityType;
import com.dhoon.japantravel.city.dto.request.TravelRecommendRequestDto;
import com.dhoon.japantravel.city.dto.response.TravelRecommendCitiesResponseDto;
import com.dhoon.japantravel.city.dto.response.TravelRecommendCityResponseDto;
import com.dhoon.japantravel.city.repository.CityRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class JapanTravelServiceTest {

    @Mock
    private CityRepository cityRepository;

    @InjectMocks
    private JapanTravelService japanTravelService;

    @Test
    void 여행일수와_추천기간의_차이가_작은_도시부터_정렬한다() {
        // given
        TravelRecommendRequestDto request =
                new TravelRecommendRequestDto(CityType.SMALL_CITY, 3);

        City yufuin =
                City.createCity("Yufuin", 1, 2, CityType.SMALL_CITY);

        City kanazawa =
                City.createCity("Kanazawa", 2, 3, CityType.SMALL_CITY);

        City city =
                City.createCity("ExampleCity", 6, 7, CityType.SMALL_CITY);

        given(cityRepository.findByCityType(CityType.SMALL_CITY))
                .willReturn(new ArrayList<>(List.of(
                        city,
                        yufuin,
                        kanazawa
                )));

        // when
        TravelRecommendCitiesResponseDto response =
                japanTravelService.recommend(request);

        // then
        assertEquals("Kanazawa",
                response.getListCities().get(0).getCityName());

        assertEquals("Yufuin",
                response.getListCities().get(1).getCityName());

        assertEquals("ExampleCity",
                response.getListCities().get(2).getCityName());
    }

    @Test
    void 요청한_CityType으로_도시를_조회한다() {
        // given
        TravelRecommendRequestDto request =
                new TravelRecommendRequestDto(CityType.LARGE_CITY, 4);

        given(cityRepository.findByCityType(CityType.LARGE_CITY))
                .willReturn(new ArrayList<>());

        // when
        japanTravelService.recommend(request);

        // then
        verify(cityRepository)
                .findByCityType(CityType.LARGE_CITY);
    }

    @Test
    void 해당_CityType의_도시가_없으면_빈_목록을_반환한다() {
        // given
        TravelRecommendRequestDto request =
                new TravelRecommendRequestDto(CityType.SMALL_CITY, 3);

        given(cityRepository.findByCityType(CityType.SMALL_CITY))
                .willReturn(new ArrayList<>());

        // when
        TravelRecommendCitiesResponseDto response =
                japanTravelService.recommend(request);

        // then
        assertEquals(0, response.getListCities().size());
    }

    @Test
    void 해당_CityType과_관련된_도시만_반환한다() {
        // given
        TravelRecommendRequestDto request =
                new TravelRecommendRequestDto(CityType.LARGE_CITY, 3);

        City tokyo =
                City.createCity("Tokyo", 3, 5, CityType.LARGE_CITY);

        City osaka =
                City.createCity("Osaka", 1, 2, CityType.LARGE_CITY);

        City kanazawa =
                City.createCity("Kanazawa", 2, 3, CityType.SMALL_CITY);

        City yufuin =
                City.createCity("Yufuin", 1, 2, CityType.SMALL_CITY);

        given(cityRepository.findByCityType(CityType.LARGE_CITY))
                .willReturn(new ArrayList<>(List.of(
                        tokyo,
                        osaka
                )));


        // when
        TravelRecommendCitiesResponseDto response =
                japanTravelService.recommend(request);

        // then
        assertEquals(2, response.getListCities().size());
        assertThat(response.getListCities()).extracting(TravelRecommendCityResponseDto::getCityName)
                .containsExactly("Tokyo", "Osaka");
    }
}