package com.slidra.slidraV1.motorcycle.dto;

import java.util.List;

//todo Need add variables
public record MotorcycleForSaleRequest (
        Long id,
        String modelId,
        Integer year,
        Integer mileage,
        Double buyPrice,
        List<String> photoUrls,
        String description,
        Double sellPrice
) {
}
