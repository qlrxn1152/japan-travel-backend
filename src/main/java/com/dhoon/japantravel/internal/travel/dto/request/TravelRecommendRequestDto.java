package com.dhoon.japantravel.internal.travel.dto.request;

import com.dhoon.japantravel.internal.travel.domain.CityType;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TravelRecommendRequestDto {

    @Min(1)
    @Min(12)
    private int travelMonth;

    @NotNull
    private CityType cityType;

    private boolean rentalCar;

    @Min(1)
    private int peopleCount;

    @Positive
    private int budget;

    @Min(1)
    private int tripDays;




}
