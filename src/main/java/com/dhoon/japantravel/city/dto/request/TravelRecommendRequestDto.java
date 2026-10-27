package com.dhoon.japantravel.city.dto.request;

import com.dhoon.japantravel.city.domain.CityType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TravelRecommendRequestDto {

    @NotNull
    private CityType cityType;

    @Min(1)
    private int tripDays;
}
