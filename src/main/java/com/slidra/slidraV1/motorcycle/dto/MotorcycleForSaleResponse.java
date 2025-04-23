package com.slidra.slidraV1.motorcycle.dto;

import java.util.List;

public record MotorcycleForSaleResponse(
        Long id,
        Long modelId,
        String modelName,
        String brandName,
        Integer year,
        Integer mileage,
        Double buyPrice,
        List<String> photoUrls,
        String description,
        Double sellPrice,
        Double soldPrice
) {}
