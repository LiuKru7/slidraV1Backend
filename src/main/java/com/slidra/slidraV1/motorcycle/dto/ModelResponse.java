package com.slidra.slidraV1.motorcycle.dto;

import com.slidra.slidraV1.motorcycle.enums.FuelType;
import com.slidra.slidraV1.motorcycle.enums.ModelCategory;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record ModelResponse(
        String name,
        Long id,
        Integer yearFrom,
        Integer yearTo,
        String generation,
        @Enumerated(EnumType.STRING)
        ModelCategory category,
        Integer engineDisplacement,
        Integer horsepower,
        Double weight,
        @Enumerated(EnumType.STRING)
        FuelType fuelType
) {
}
