package com.slidra.slidraV1.motorcycle.mapper;

import com.slidra.slidraV1.motorcycle.dto.MotorcycleForSaleRequest;
import com.slidra.slidraV1.motorcycle.dto.MotorcycleForSaleResponse;
import com.slidra.slidraV1.motorcycle.model.MotorcycleForSale;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MotorcycleForSaleMapper {

    //todo need check expression
    @Mapping(target = "modelName", expression = "java(motorcycleForSale.getModel().getName())")
    @Mapping(target = "brandName", expression = "java(motorcycleForSale.getModel().getBrand().getName())")
    MotorcycleForSaleResponse toMotorcycleForSaleResponse(MotorcycleForSale motorcycleForSale);
    MotorcycleForSale toMotorcycleForSale(MotorcycleForSaleRequest motorcycleForSaleRequest);
}
