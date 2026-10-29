package com.dhoon.japantravel.city.controller;

import com.dhoon.japantravel.city.domain.City;
import com.dhoon.japantravel.city.dto.request.TravelRecommendRequestDto;
import com.dhoon.japantravel.city.dto.response.TravelRecommendCitiesResponseDto;
import com.dhoon.japantravel.city.service.JapanTravelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
@RequiredArgsConstructor
public class JapanTravelController {

    private final JapanTravelService service;

    @PostMapping("/api/travel/recommend")
    public ResponseEntity<TravelRecommendCitiesResponseDto> recommend(@Valid @RequestBody TravelRecommendRequestDto requestDto) {
        TravelRecommendCitiesResponseDto response = service.recommend(requestDto);

        return ResponseEntity.ok(response);
    }


}
