package com.slidra.slidraV1.motorcycle.dto;

import com.slidra.slidraV1.motorcycle.enums.FuelType;
import com.slidra.slidraV1.motorcycle.enums.ModelCategory;

//todo Add validations
public record ModelRequest(
        String name,
        Integer yearFrom,
        Integer yearTo,
        String generation,
        ModelCategory category,
        Integer engineDisplacement,
        Integer horsepower,
        Double weight,
        FuelType fuelType
) { }