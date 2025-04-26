package com.slidra.slidraV1.motorcycle.mapper;

import com.slidra.slidraV1.motorcycle.dto.BrandRequest;
import com.slidra.slidraV1.motorcycle.dto.BrandResponse;
import com.slidra.slidraV1.motorcycle.model.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface BrandMapper {

    BrandResponse toBrandResponse(Brand brand);
    @Mapping(target = "models", ignore = true)
    @Mapping(target = "id", ignore = true)
    Brand toBrand(BrandRequest brandRequest);
}