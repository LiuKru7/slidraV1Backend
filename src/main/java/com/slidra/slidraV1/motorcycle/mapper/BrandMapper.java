package com.slidra.slidraV1.motorcycle.mapper;

import com.slidra.slidraV1.motorcycle.dto.BrandRequest;
import com.slidra.slidraV1.motorcycle.dto.BrandResponse;
import com.slidra.slidraV1.motorcycle.model.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring")
public interface BrandMapper {

    BrandResponse toBrandResponse(Brand brand);

    Brand toBrand(BrandRequest brandRequest);
}